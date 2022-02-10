package com.dhy.designpatterns.othersPattern.gugong;

/**
 * @Project fighting-core
 * @Description 厨房可被清理
 * @Author lvaolin
 * @Date 2022/2/10 上午11:23
 */
public class Kitchen implements Cleanable {
    @Override
    public void cleaned() {
        System.out.println("清理厨房");
    }
}
