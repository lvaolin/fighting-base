package com.dhy.proxy.jdk1;

import com.dhy.proxy.jdk1.target.Hello;
import com.dhy.proxy.jdk1.target.IHello;
import com.dhy.proxy.jdk1.target.IPerson;
import com.dhy.proxy.jdk1.target.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author lvaolin
 * @create 2020/4/13 5:56 PM
 */
public class Client1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //-----简单工厂模式生成对象-----
        IPerson person = (IPerson) Factory.getInstance("person");
        person.eat();
        IHello hello = (IHello)  Factory.getInstance("hello");
        hello.say();
        System.out.println("----------------");

        //-----
        IPerson person1 = (IPerson) Factory.getInstance(new Person());
        person1.eat();

        //-----jdk动态代理模式生成对象-----
        IHello helloJdk = (IHello)  Proxy.newProxyInstance(Hello.class.getClassLoader(),Hello.class.getInterfaces(),new MyProxy(new Hello()));
        helloJdk.say();
        System.out.println("----------------");

    }
}
