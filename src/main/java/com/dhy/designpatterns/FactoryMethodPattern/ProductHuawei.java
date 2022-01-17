package com.dhy.designpatterns.FactoryMethodPattern;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/17 下午3:06
 */
public class ProductHuawei implements IProduct {
    @Override
    public void sing() {
        System.out.println("hi，我是华为音乐播放器，我正在唱歌。。。。。");
    }
}
