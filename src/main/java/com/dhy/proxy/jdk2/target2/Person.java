package com.dhy.proxy.jdk2.target2;

/**
 * @author lvaolin
 * @create 2020/4/13 5:55 PM
 */
public class Person implements IPerson {
    private String name;
    public Person(String name){
        this.name = name;
    }
    @Override
    public String eat() {
        System.out.println(name+" 正在吃饭");
        return null;
    }
}
