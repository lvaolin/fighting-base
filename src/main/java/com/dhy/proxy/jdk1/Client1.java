package com.dhy.proxy.jdk1;


import com.dhy.proxy.cglibInterface.IPerson;
import com.dhy.proxy.jdk1.target1.Hello;
import com.dhy.proxy.jdk1.target1.IHello;
import com.dhy.proxy.jdk1.target1.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author lvaolin
 * @create 2020/4/13 5:56 PM
 */
public class Client1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //-----简单工厂模式生成对象-----
        IPerson person = Factory.getInstance("person");
        person.eat();
        IHello hello = Factory.getInstance("hello");
        hello.say();
        System.out.println("----------------");

        //-----
        IPerson person1 = Factory.getInstance(new Person());
        person1.eat();

        //-----jdk动态代理模式生成对象-----
        IHello helloJdk = (IHello)  Proxy.newProxyInstance(Hello.class.getClassLoader(),Hello.class.getInterfaces(),new MyProxy(new Hello()));
        helloJdk.say();
        System.out.println("----------------");

    }
}
