package com.dhy.proxy.jdk2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lvaolin
 * @create 2020/4/13 5:56 PM
 */
public class MyProxyFactory implements InvocationHandler{

    private Object origin;
    public MyProxyFactory(Object origin){
        this.origin = origin;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(origin,args);
        System.out.println("after");
        return result;
    }

    /**
     * 获取代理对象
     * @param origin 原始对象
     * @return 代理对象
     */
    public static <R> R getInstance(Object origin){
        return (R)Proxy.newProxyInstance(origin.getClass().getClassLoader(),origin.getClass().getInterfaces(),new MyProxyFactory(origin));
    }

}
