package com.dhy.proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * cglib 生成代理对象，目标对象不需要有接口，这是和jdk proxy的区别
 * @author lvaolin
 * @create 2020/4/14 10:54 AM
 */
public class Client2 {
    public static void main(String[] args) {
        //原始方式------
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(new MyCglibMethodInterceptor());
        Person person = (Person)enhancer.create();
        person.eat();
        System.out.println("-------------");

        //改进方式，用简单工厂设计模式 把创建代理的过程隐藏，直接返回代理对象
        Person person1 = (Person) CglibFactory.getInstance(Person.class,new MyCglibMethodInterceptor());
        person1.eat();
    }

}

/**
 * 简单工厂设计模式
 * @author lvaolin
 * @create 2020/4/14 11:02 AM
 */
class CglibFactory {
    public static Object getInstance(Class target, Callback callback){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        enhancer.setCallback(callback);
        return enhancer.create();
    }
}
