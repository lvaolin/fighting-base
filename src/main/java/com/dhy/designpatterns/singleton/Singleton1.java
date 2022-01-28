package com.dhy.designpatterns.singleton;

/**
 * @Title Singleton
 * @Description  懒加载模式实现单例
 * @Author lvaolin
 * @Date 2022/1/28 21:45
 **/
public class Singleton1 {
    private static Singleton1 singleton;
    private Singleton1(){

    }

    public  static Singleton1 getInstance(){
        if (singleton==null) {
            synchronized (Singleton1.class){//多线程问题，double check 解决
                if (singleton==null) {
                    singleton = new Singleton1();
                    singleton.ready();//防止指令重排序问题
                }
            }
        }
        return singleton;
    }

    void ready(){
        System.out.println("ready");
    }
}
