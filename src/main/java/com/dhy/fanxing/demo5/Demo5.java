package com.dhy.fanxing.demo5;

/**
 * @Project fighting-core
 * @Description 泛型定义在接口上
 * @Author lvaolin
 * @Date 2022/3/30 下午3:21
 */
public class Demo5 {
    public static void main(String[] args) {
        IHello hello = new HelloImpl();
        System.out.println(hello.sayHello(new C()));
    }
}

interface IHello{
    <T extends A> String sayHello(T t);
}

class HelloImpl implements IHello{
    @Override
    public <T extends A> String sayHello(T t) {
        return t.getName();
    }
}

class A{
    String getName(){
        return "A";
    }
}

class B extends A{
    String getName(){
        return "B";
    }
}

class C extends B{
    String getName(){
        return "C";
    }
}