package com.dhy.designpatterns.othersPattern.gugong;

/**
 * @Project fighting-core
 * @Description 花园可以被清理
 * @Author lvaolin
 * @Date 2022/2/10 上午11:22
 */
public class Garden implements Cleanable {
    @Override
    public void cleaned() {
        System.out.println("清理花园");
    }
}
