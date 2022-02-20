package com.dhy.proxy.cglibInterface;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lvaolin
 * @create 2020/4/14 10:50 AM
 */
public class MyCglibMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我饭前洗手");
        //System.out.println(method.getName());
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("我饭后漱口");
        return result;
    }

}
