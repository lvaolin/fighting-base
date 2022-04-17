package com.dhy.dhytest.singleton;

/**
 * 饿汉式
 */
public class Singleton1 {
    private Singleton1(){
        System.out.println("inited");
    }
    private static final Singleton1 instance = new Singleton1();
    public static Singleton1 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(Singleton1.getInstance() == Singleton1.getInstance());

    }
}
