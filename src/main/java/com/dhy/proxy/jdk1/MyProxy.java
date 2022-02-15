package com.dhy.proxy.jdk1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lvaolin
 * @create 2020/4/13 5:56 PM
 */
public class MyProxy implements InvocationHandler{

    /**
     * 原始对象
     */
    private Object origin;
    public MyProxy(Object origin){
        this.origin = origin;
    }

    /**
     *
     * @param proxy
     * @param method 方法
     * @param args  参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(origin,args);
        System.out.println("after");
        return result;
    }
}
