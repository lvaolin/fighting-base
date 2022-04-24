package com.dhy.juc.singleton;


/**
 * 静态内部类实现 单例模式
 */
public class StaticInnerClass {

    private StaticInnerClass(){
        System.out.println("init");
    };
    private static class InnerClass{
        private static final StaticInnerClass instance = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance(){
        return InnerClass.instance;
    }
}

class StaticInnerClassTest{
    public static void main(String[] args) {
        StaticInnerClass instance = StaticInnerClass.getInstance();
        System.out.println(instance);
    }
}