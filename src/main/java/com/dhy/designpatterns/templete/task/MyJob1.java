package com.dhy.designpatterns.templete.task;

/**
 * @Title MyJob1
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 18:40
 **/
public class MyJob1 extends AbstractJob {


    @Override
    Object[] queryTask() {
        Object[] a = {"mytask1","mytask2"};
        return a;
    }

    @Override
    void processData(Object data) {
        System.out.println(data+"处理中");
    }
}
