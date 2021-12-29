package com.dhy.designpatterns.composite.migration;

/**
 * @Project fighting-core
 * @Description 迁移任务
 * @Author lvaolin
 * @Date 2021/12/29 下午2:44
 */
public interface IMigrationTask {
    /**
     * 开始迁移
     */
    void startMove();

    /**
     * 迁移耗时
     * @return
     */
    long costTime();
}
