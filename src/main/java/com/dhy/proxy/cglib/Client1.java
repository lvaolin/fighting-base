package com.dhy.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * cglib 生成代理对象，目标对象不需要有接口，这是和jdk proxy的区别
 * @author lvaolin
 * @create 2020/4/14 10:54 AM
 */
public class Client1 {
    public static void main(String[] args) {
        //原始方式------
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(new MyCglibMethodInterceptor());
        Person person = (Person)enhancer.create();
        person.eat();
        System.out.println("-------------");

    }
}
