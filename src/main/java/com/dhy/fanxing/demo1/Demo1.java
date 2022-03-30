package com.dhy.fanxing.demo1;

import java.util.Date;

/**
 * @Project fighting-core
 * @Description 泛型声明在类上,作用域整个类，都可以用
 * @Author lvaolin
 * @Date 2022/3/30 上午11:22
 */
public class Demo1 {
    public static void main(String[] args) {
        Hello<Date> dateHello = new Hello<>();
        Date date = dateHello.sayHello(new Date());
        System.out.println(date.toString());
    }
}

class Hello<T>{
    T sayHello(T t){
        System.out.println(t.getClass().getCanonicalName());
        return t;
    }
}