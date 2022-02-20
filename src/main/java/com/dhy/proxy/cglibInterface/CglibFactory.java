package com.dhy.proxy.cglibInterface;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * 简单工厂设计模式
 * @author lvaolin
 * @create 2020/4/14 11:02 AM
 */
public class CglibFactory {
    public static Object getInstance(Class target, Callback callback){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        enhancer.setCallback(callback);
        return enhancer.create();
    }
}
