package com.dhy.proxy.cglibInterface;

/**
 * cglib 使用接口生成代理对象，
 * @author lvaolin
 * @create 2020/4/14 10:54 AM
 */
public class Client {
    public static void main(String[] args) {
        //代理有接口的类
        IPerson person1 = (IPerson) CglibFactory.getInstance(Person.class,new MyCglibMethodInterceptor());
        person1.eat();
        //代理没有接口的类
        Dog dog = (Dog) CglibFactory.getInstance(Dog.class,new MyCglibMethodInterceptor());
        dog.eat();
    }
}
