package com.dhy.designpatterns.composite.migration;

/**
 * @Project fighting-core
 * @Description 上下文模拟
 * @Author lvaolin
 * @Date 2021/12/29 下午3:01
 */
public class Main {

    public static void main(String[] args) {
        MigrationNode root = new MigrationNode();

        MigrationNode level21 = new MigrationNode();
        MigrationNode level22 = new MigrationNode();

        //第二层节点
        MigrationNode[] level2 = {level21,level22};


        MigrationNode level2101 = new MigrationNode();
        MigrationNode level2102 = new MigrationNode();
        MigrationNode level2103 = new MigrationNode();

        //第三层节点
        MigrationNode[] level3 = {level2101,level2102,level2103};

        root.setSubMigrationNode(level2);

        level21.setSubMigrationNode(level3);

        root.startMove();

        System.out.println(root.costTime());

    }
}
