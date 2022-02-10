package com.dhy.designpatterns.othersPattern.gugong;

/**
 * @Project fighting-core
 * @Description 衣服可被清理
 * @Author lvaolin
 * @Date 2022/2/10 上午11:25
 */
public class Cloth implements Cleanable{

    @Override
    public void cleaned() {
        System.out.println("清理衣服");
    }
}
