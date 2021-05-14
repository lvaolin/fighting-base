package com.dhy.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryOneTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.TimeUnit;

/**
 * 基于zookeeper的分布式锁实现
 * @author lvaolin
 * @create 18/3/7 上午10:38
 */
public class DlockUtil {

    private static final Logger logger = LoggerFactory.getLogger(DlockUtil.class);
    private static final String ZK_LOCK_PATH = "/dhy/";
    private static CuratorFramework client = null;
    static {
        RetryPolicy retryPolicy = new RetryOneTime(60000);
        client = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .connectionTimeoutMs(5000)
                .retryPolicy(retryPolicy)
                .namespace("dlock")
                .build();
        client.start();
        logger.info("zk client start successfully!");
    }

    /**
     * 获取分布式锁，如果获取失败会立刻返回，不会等待
     * 注意：调用方需要保留 此方法的 返回值，在finally里调用releaseDLock(lock) 进行锁释放
     *
     * @param orgId      企业ID
     * @param moduleName 业务模块名称  英文
     * @param lockName   锁名称(具体业务操作命名)  英文
     * @return 返回值为null 代表 获取锁失败，非null代表 获取锁成功
     */
    public static InterProcessMutex getDLock(String orgId, String moduleName, String lockName) {
        return getDLock(orgId, moduleName, lockName, 0);
    }

    /**
     * 获取分布式锁（可指定获取锁超时时间）
     * 注意：调用方需要保留 此方法的 返回值，在finally里调用releaseDLock(lock) 进行锁释放
     * InterProcessMutex.isAcquiredInThisProcess() 可以准确判断是否还持有锁
     *
     * @param orgId      企业ID
     * @param moduleName 业务模块名称  英文
     * @param lockName   锁名称(具体业务操作命名)  英文
     * @param second     超时时间 ：-1代表一直堵塞,直到获取成功；0代表不等待，如果获取失败，立刻返回；大于0 则表示会尝试排队获取锁，直到超时就返回
     * @return 返回值为null 代表 获取锁失败，非null代表 获取锁成功
     */
    public static InterProcessMutex getDLock(String orgId, String moduleName, String lockName, long second) {
        if (client == null) {
            logger.error("client == null，未启用分布式锁DLOCK");
            return null;
        }
        InterProcessMutex lock = new InterProcessMutex(client, ZK_LOCK_PATH + orgId + "/" + moduleName + "/" + lockName);
        try {
            if (second == -1) {
                //-1代表一直堵塞下去直到获取成功
                logger.info("-1 正在获取分布式锁..." + Thread.currentThread().getName());
                lock.acquire();
                logger.info("获取分布式锁成功" + Thread.currentThread().getName());
                return lock;
            } else {
                //获取不到锁就返回获取锁失败
                logger.info(second + " 正在获取分布式锁..." + Thread.currentThread().getName());
                if (lock.acquire(second, TimeUnit.SECONDS)) {
                    logger.info("获取分布式锁成功" + Thread.currentThread().getName());
                    return lock;
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            logger.error("获取分布式锁失败:" + e.getMessage(), e);
            return null;
        }
    }

    /**
     * 释放分布式锁
     * 注意：此方法需要在finally里进行调用
     *
     * @param lock 要释放的锁，来自于getDLock()的返回值
     */
    public static void releaseDLock(InterProcessMutex lock) {
        try {
            if (lock != null) {
                //判断是否还持有锁
                if (lock.isAcquiredInThisProcess()) {
                    lock.release();
                    //是否是最后一把锁
                    if (!lock.isAcquiredInThisProcess()) {
                        lock = null;
                    }
                } else {
                    lock = null;
                }
                logger.info("释放锁成功:" + Thread.currentThread().getName());
            } else {
                logger.info("无需释放" + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            logger.error("释放分布式锁失败:" + e.getMessage(), e);
        }
    }
}
