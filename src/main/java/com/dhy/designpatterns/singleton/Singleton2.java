package com.dhy.designpatterns.singleton;

/**
 * @Title Singleton2
 * @Description 提前实例化
 * @Author lvaolin
 * @Date 2022/1/28 21:51
 **/
public class Singleton2 {
    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        return singleton2;
    }
}
