package com.dhy.designpatterns.composite.migration;

import lombok.Data;

/**
 * @Project fighting-core
 * @Description 迁移节点
 * @Author lvaolin
 * @Date 2021/12/29 下午2:49
 */
@Data
public class MigrationNode implements IMigrationTask{
    private IMigrationTask[] subMigrationNode;

    @Override
    public void startMove() {
        if (subMigrationNode!=null) {
            //容器节点
            for (IMigrationTask migrationNode : subMigrationNode) {
                migrationNode.startMove();
            }
        }else{
            //叶子节点
            System.out.println("开始迁移");
        }
    }

    @Override
    public long costTime() {

        long totalTime = 0;
        if (subMigrationNode!=null) {
            //容器节点
            for (IMigrationTask migrationNode : subMigrationNode) {
                totalTime += migrationNode.costTime();
            }

        }else{
            //叶子节点
            totalTime = 1;
        }

        return totalTime;
    }


}
