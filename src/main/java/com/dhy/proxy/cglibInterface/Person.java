package com.dhy.proxy.cglibInterface;


/**
 * @author lvaolin
 * @create 2020/4/14 10:49 AM
 */
public class Person implements IPerson {
    @Override
    public void eat(){
        System.out.println("吃饭");
    }
}
