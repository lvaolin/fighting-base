package com.dhy.proxy.cglibInterface;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * 简单工厂设计模式
 * @author lvaolin
 * @create 2020/4/14 11:02 AM
 */
public class CglibFactory {
    public static<T,R> R getProxy(Class<T> target, Callback callback, Class[] argumentTypes, Object[] arguments){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        enhancer.setCallback(callback);
        if (argumentTypes!=null&&arguments!=null) {
            //有参构造器
            return (R)enhancer.create(argumentTypes,arguments);
        }else{
            //无参构造器
            return (R)enhancer.create();
        }

    }
}
