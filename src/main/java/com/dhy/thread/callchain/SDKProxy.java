package com.dhy.thread.callchain;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2023/4/7 上午10:47
 */
public class SDKProxy implements InvocationHandler {
private Object targetObj;
    public SDKProxy(Object targetObj){
this.targetObj = targetObj;
    }
    public ISDK getProxy(){
        return (ISDK)Proxy.newProxyInstance(this.getClass().getClassLoader(), SDK.class.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Util.getCallChain();
        return method.invoke(targetObj, args);
    }
}
