package com.dhy.juc.singleton;

/**
 * 懒汉式  双重校验
 */
public class Singleton2 {
    private Singleton2(){
        System.out.println("inited----------------------------");
    }
    private volatile static Singleton2 instance;
    public static Singleton2 getInstance(){
        if (instance==null) {
            synchronized (Singleton2.class){
                if (instance==null) {
                    instance = new Singleton2();
                }
            }
        }

        return instance;
    }


    public static void main(String[] args) {
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
    }
}
