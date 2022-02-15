package com.dhy.proxy.jdk1;

import com.dhy.proxy.jdk1.target.Hello;
import com.dhy.proxy.jdk1.target.IHello;

import java.lang.reflect.Proxy;

/**
 * @author lvaolin
 * @create 2020/4/13 5:56 PM
 */
public class Client2 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        //------传统方式生成对象--------
        IHello hello3 = new Hello();
        hello3.say();
        System.out.println("----------------");

        //-----类反射生成对象---------
        IHello hello2 = Hello.class.newInstance();
        hello2.say();
        System.out.println("----------------");

        //-----jdk动态代理模式生成对象-----
        IHello helloJdk = (IHello)  Proxy.newProxyInstance(Hello.class.getClassLoader(),Hello.class.getInterfaces(),new MyProxy(new Hello()));
        helloJdk.say();
        System.out.println("----------------");
    }
}
