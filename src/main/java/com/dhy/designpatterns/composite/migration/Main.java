package com.dhy.designpatterns.composite.migration;

import java.util.UUID;

/**
 * @Project fighting-core
 * @Description 上下文模拟
 * @Author lvaolin
 * @Date 2021/12/29 下午19:49
 */
public class Main {

    public static void main(String[] args) {
        //顶级任务
        MigrationNode job = new MigrationNode();

        //二级任务
        MigrationNode agency01 = new MigrationNode();
        MigrationNode agency02 = new MigrationNode();

        //三级任务
        MigrationNode org0101 = new MigrationNode(UUID.randomUUID().toString());
        MigrationNode org0102 = new MigrationNode(UUID.randomUUID().toString());
        MigrationNode org0103 = new MigrationNode(UUID.randomUUID().toString());

        MigrationNode org0201 = new MigrationNode(UUID.randomUUID().toString());
        MigrationNode org0202 = new MigrationNode(UUID.randomUUID().toString());
        MigrationNode org0203 = new MigrationNode(UUID.randomUUID().toString());

        //任务组合
        job.add(agency01);
        job.add(agency02);

        //任务组合
        agency01.add(org0101);
        agency01.add(org0102);
        agency01.add(org0103);
        //任务组合
        agency02.add(org0201);
        agency02.add(org0202);
        agency02.add(org0203);

        //启动任务
        job.startMove();
        //统计耗时
        System.out.println("总耗时统计："+job.costTime());

    }
}
