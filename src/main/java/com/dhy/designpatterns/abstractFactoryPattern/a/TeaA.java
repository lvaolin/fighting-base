package com.dhy.designpatterns.abstractFactoryPattern.a;

import com.dhy.designpatterns.abstractFactoryPattern.Tea;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/17 下午5:11
 */
public class TeaA implements Tea {
    @Override
    public void show() {
        System.out.println("我是A牌茶叶");
    }
}
