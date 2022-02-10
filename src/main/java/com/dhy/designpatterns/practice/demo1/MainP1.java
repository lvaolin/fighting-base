package com.dhy.designpatterns.practice.demo1;

/**
 * @Project fighting-core
 * @Description 模板方法模式：
 * 由一个方法来串联多个其它方法，其中有的是抽象的方法
 * 不同用途的子类来实现自己想要的抽象方法。
 *
 * 最大化的实现代码复用。
 *
 * 用了继承来实现
 *
 * @Author lvaolin
 * @Date 2022/2/9 上午10:49
 */
public class MainP1 {
    public static void main(String[] args) {
        ServiceBase serviceBase = new MyService1();
        serviceBase.templateMethod();

        serviceBase = new MyService2();
        serviceBase.templateMethod();
    }
}

abstract class ServiceBase{
    //不让子类覆盖这个模板方法
    final void templateMethod(){
        m1();
        m2();
        m3();
    }

    private void m1(){
        System.out.println("第一步");
    }
    abstract void m2();
    private void m3(){
        System.out.println("第三步");
    }
}

class MyService1 extends ServiceBase{
    @Override
    void m2() {
        System.out.println("MyService1 第二步实现");
    }
}

class MyService2 extends ServiceBase{
    @Override
    void m2() {
        System.out.println("MyService2 第二步实现");
    }
}