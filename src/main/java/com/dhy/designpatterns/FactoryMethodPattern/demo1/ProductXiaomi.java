package com.dhy.designpatterns.FactoryMethodPattern.demo1;

import com.dhy.designpatterns.FactoryMethodPattern.demo1.IProduct;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/17 下午3:06
 */
public class ProductXiaomi implements IProduct {
    @Override
    public void sing() {
        System.out.println("hi，我是小米音乐播放器，我正在唱歌。。。。。");
    }
}
