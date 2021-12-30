package com.dhy.designpatterns.composite.migration;

/**
 * @Project fighting-core
 * @Description 迁移任务
 * @Author lvaolin
 * @Date 2021/12/29 下午19:49
 */
public interface IMigrationTask {
    /**
     * 迁移启动
     */
    void startMove();

    /**
     * 迁移耗时统计
     * @return
     */
    long costTime();


    void add(IMigrationTask migrationTask);

    void remove(IMigrationTask migrationTask);
}
