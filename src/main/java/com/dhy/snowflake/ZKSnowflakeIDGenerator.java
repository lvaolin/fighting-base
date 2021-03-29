package com.dhy.snowflake;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.curator.utils.CloseableUtils;
import org.apache.curator.utils.ZKPaths;
import org.apache.zookeeper.KeeperException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * 基于Twitter-Snowflake算法和Zookeeper实现的分布式ID生成器（64Bit自增ID），参考https://github.com/twitter/snowflake<br/>
 * <p>
 * ID为64位非负long类型整数，结构如下<br/>
 * <ui>
 * <li>40 bits 时间戳（time stamp）</li>
 * <li>6 bits 集群机器ID（machine id）或进程ID，可简单理解为集群机器ID</li>
 * <li>10 bits 序列号（sequence number）</li>
 * </ui>
 *
 */
@Component
@CommonsLog
public class ZKSnowflakeIDGenerator extends AbstractSnowflakeIDGenerator {

    /**
     * ZK管理器
     */
    @Autowired
    private ZkManager zkManager = new ZkManager();
    /**
     * Zk连接状态监听器
     */
    private ZkConnectionStateListener stateListener = new ZkConnectionStateListener(this);
    /**
     * ID生成器是否处于工作状态
     */
    private volatile boolean isWorking = false;

    /**
     * 上一次时间戳
     */
    private volatile long lastTimestamp = -1L;
    /**
     * 集群内机器ID
     */
    private volatile long datacenterId;
    /**
     * 集群id
     */
    private volatile long clusterId;
    /**
     * 序列号
     */
    private volatile long sequence = 0L;

    public ZKSnowflakeIDGenerator(ZkManager zkManager) throws UnsupportedEncodingException, InterruptedException {
        this.zkManager = zkManager;
    }

    public ZKSnowflakeIDGenerator(){

    }

    @PostConstruct
    public void init() throws Exception {
        // 监听连接状态
        zkManager.addConnectionStateListener(stateListener);
        // 生成初始集群机器ID
        rebuildDatacenterId();
        clusterId = getClusterId();
        isWorking = true;

        sequence = 0L;
        lastTimestamp = -1L;

        log.info("idGenerator is isWorking!");
    }

    //从配置读取集群id，如果没有配置，默认0
    private long getClusterId() {
        String oidClusterId = PropertyUtil.getPropertyByKey("OID_CLUSTER_ID");
        long ret;
        if (StringUtil.isNumber(oidClusterId)) {
            ret = Long.parseLong(oidClusterId) % MAX_CLUSTER;
        }
        else {
            ret = 0L;
        }

        log.error("初始化OID_CLUSTER_ID：" + ret);
        return ret;
    }


    @Override
    public long getId() {
        if (isWorking) {
            return nextId();
        }
        // 处于异常状态（会话过期，连接中断等），ID生成器停止工作
        throw new RuntimeException("IDGenerator is not isWorking!");
    }

    /**
     * 获取下一个ID
     *
     * //TODO by zhouyu 在分布式集群的情况下，ID生成，仍然需要保持的一些特性：
     * 1）集群唯一性 -- 添加datacenterId（machineID）来区分不同服务器生成的ID
     * 2）集群自增性（涉及按id的默认排序） -- 在不同毫秒内保持增长，同一毫秒内，由于带machineID，暂时无法自增 TODO：多服务之间毫秒级的时间同步
     * 3）集群均匀性 -- TODO： 序列号sequence，总是从0开始，导致生成的ID多为"偶数"（实际上基本都是1024的整数倍）
     * 4）长度限制56位二进制 -- javascript的Number.MAX_SAFE_INTEGER = 9007199254740991，当超长以后，传给前端会出错
     */
//    long ID_EPOCH = 0x1532af4e2ddL;     //十进制1456714605277， 时间是2016-02-29 10:56:45
                                        // 时间戳每年新增约31536000000，
                                        // 目前已经使用的最小orgId是4349271207189504，在新算法下，对应时间戳：4349271207189504/2^11 + 1456714605277 = 3580382186912
                                        // 当前时间：2019-09-26 17:22:37，约1569489757202，约可使用63年，区间与最小orgId不重叠：(3580382186912 - 1569489757202)/31536000000=63.7
//    long SEQUENCE_MASK = 255L;          //2的8次方
//    int DATACENTER_ID_SHIFT = 6;        //服务id号左移位数，即流水号位数，6位
//    CLUSTER_SHIFT = 9                     //集群id号左移位数，即流水号位数 + 服务id位数，9位
//    int TIMESTAMP_LEFT_SHIFT = 11;      //时间戳左移位数，即流水号位数 + 服务id位数 + 集群id位数，11位
    private synchronized long nextId() {
        long timestamp = currentTimeMillis();
        if (timestamp < lastTimestamp) {
            log.warn(String.format("Clock moved backwards. Refusing to generate id for %s milliseconds.",
                    (lastTimestamp - timestamp)));
            try {
                Thread.sleep((lastTimestamp - timestamp));
            } catch (InterruptedException e) {
                log.info(e);
            }
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
//            sequence = sequence + 1L & 1023L;
            if (sequence == 0) {
                // 一毫秒内产生的ID达到了SEQUENCE_MASK个，等待下一毫秒
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = timestamp;
        //String info = String.format("timesstamp:%s,datacenterId:%s,sequence:%s",String.valueOf(timestamp),String.valueOf(datacenterId),String.valueOf(sequence));
        //logger.error(info);
        // Twitter-Snowflake算法
//        return (timestamp - 0x1532af4e2ddL) << 16 | datacenterId << 10 | sequence;
        return ((timestamp - ID_EPOCH) << TIMESTAMP_LEFT_SHIFT) | (clusterId << CLUSTER_SHIFT) | (datacenterId << DATACENTER_ID_SHIFT) | sequence;
    }


    /**
     * 重新生成集群机器ID，两种情况下需要rebuild，且isWorking必须为false<br/>
     * <ui>
     * <li>应用初始化，获取初始集群机器ID</li>
     * <li>重连后的恢复操作，由ZK连接状态监听器触发</li>
     * <ui/>
     *
     * @throws Exception
     */
    public void rebuildDatacenterId() throws Exception {
        if (isWorking) {
            throw new RuntimeException("IDGenerator is isWorking , no need to rebuild datacenter id ");
        }
        datacenterId = buildDatacenterId();
    }

    /**
     * 生成唯一的集群机器ID
     *
     * @return
     */
    private synchronized long buildDatacenterId() throws Exception {
        try {
            // 已分配的集群机器ID
            List<String> usedMachineIds = zkManager.getChildren();
            if (MAX_DATACENTER_ID <= usedMachineIds.size()) {
                throw new RuntimeException(String.format("reach limit of max_datacenter_id:%s , useIds.size:%s",
                        MAX_DATACENTER_ID, usedMachineIds.size()));
            }
            // 尚未分配的集群机器ID
            List<Long> unusedMachineIds = LongStream.range(0, MAX_DATACENTER_ID)
                    .filter(value -> !usedMachineIds.contains(value))
                    .boxed().collect(Collectors.toList());
            // 随机选择一个尚未分配的集群机器ID
            Long datacenterId = unusedMachineIds.get(RANDOM.nextInt(unusedMachineIds.size()));
            if (zkManager.tryCreate(ZKPaths.makePath("/", datacenterId.toString()), true)) {
                // 成功创建则返回
                return datacenterId;
            }
            // 创建失败则递归调用
            Thread.sleep(RANDOM.nextInt(500)); // 为了降低竞争冲突概率，可选
            return buildDatacenterId();
        } catch (KeeperException.NoNodeException e) {
            // zkManager.getChildren()可能数据节点尚不存在
            long datacenterId = 0;
            if (zkManager.tryCreate(String.valueOf(datacenterId), true)) {
                return datacenterId;
            }
            Thread.sleep(RANDOM.nextInt(500));
            return buildDatacenterId();
        }
    }

    /**
     * 等到下一毫秒
     *
     * @param lastTimestamp
     * @return
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = currentTimeMillis();
        }
        return timestamp;
    }

    /**
     * 获取当前毫秒数
     *
     * @return
     */
    private long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 暂停工作，进入休眠状态
     */
    public void suspend() {
        this.isWorking = false;
    }

    /**
     * 恢复工作
     */
    public void recover() {
        this.isWorking = true;
    }

    /**
     * Spring容器关闭前先停止ID生成器的工作，并关闭ZK管理器
     */
    @Override
    @PreDestroy
    public void close() throws IOException {
        log.info("close zkManager before shutdown...");
        suspend();
        CloseableUtils.closeQuietly(zkManager);
    }

    /**
     * 重新与Zookeeper建立连接，由ZK连接状态监听器触发
     */
    public void reconnect() {
        log.info("try to reconnect...");
        if (isWorking) {
            return;
        }
        try {
            zkManager.connect();
        } catch (Exception e) {
            log.error("reconnect fail!!", e);
        }
    }
}
