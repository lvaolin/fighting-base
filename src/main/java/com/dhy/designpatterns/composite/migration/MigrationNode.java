package com.dhy.designpatterns.composite.migration;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Project fighting-core
 * @Description 迁移节点
 * @Author lvaolin
 * @Date 2021/12/29 下午19:49
 */
@Data
public class MigrationNode implements IMigrationTask{
    private String orgId;
    private List<IMigrationTask> migrationNodeList = new ArrayList<>();
    private long costTime = 0;

    public MigrationNode(){
    }
    public MigrationNode(String orgId){
        this.orgId = orgId;
    }

    @Override
    public void startMove() {
        if (migrationNodeList.size()>0) {
            //容器节点
            for (IMigrationTask migrationNode : migrationNodeList) {
                migrationNode.startMove();
            }
        }else{
            costTime = new Random().nextInt(100);
            //叶子节点
            System.out.println("企业"+orgId+"开始迁移，耗时："+costTime);


        }
    }

    @Override
    public long costTime() {

        if (migrationNodeList.size()>0) {
            //容器节点
            for (IMigrationTask migrationNode : migrationNodeList) {
                costTime += migrationNode.costTime();
            }
        }
        return costTime;
    }

    @Override
    public void add(IMigrationTask migrationTask) {
        migrationNodeList.add(migrationTask);
    }

    @Override
    public void remove(IMigrationTask migrationTask) {
        migrationNodeList.remove(migrationTask);
    }


}
