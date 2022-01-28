package com.dhy.designpatterns.templete.task;

/**
 * @Title YourJob1
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 18:40
 **/
public class YourJob1 extends AbstractJob {


    @Override
    Object[] queryTask() {
        Object[] a = {"yourtask1","yourtask2"};
        return a;
    }

    @Override
    void processData(Object data) {
        System.out.println(data+"处理中");
    }
}
