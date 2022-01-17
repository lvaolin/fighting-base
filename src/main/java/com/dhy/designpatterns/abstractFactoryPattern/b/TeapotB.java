package com.dhy.designpatterns.abstractFactoryPattern.b;

import com.dhy.designpatterns.abstractFactoryPattern.Teapot;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/17 下午5:11
 */
public class TeapotB implements Teapot {
    @Override
    public void show() {
        System.out.println("我是B牌茶壶");
    }
}
