package com.dhy.proxy.cglibInterface;

/**
 * cglib 使用接口生成代理对象，
 * @author lvaolin
 * @create 2020/4/14 10:54 AM
 */
public class Client {
    public static void main(String[] args) {
        //代理有接口的类
        IPerson person1 = CglibFactory.getProxy(Person.class,new MyCglibMethodInterceptor(),null,null);
        person1.eat();
        //代理没有接口的类
        Dog dog =CglibFactory.getProxy(Dog.class,new MyCglibMethodInterceptor(),null,null);
        dog.eat();
    }
}
