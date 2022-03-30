package com.dhy.fanxing.demo4;

/**
 * @Project fighting-core
 * @Description 类上和方法上同时声明泛型
 * @Author lvaolin
 * @Date 2022/3/30 上午12:22
 */
public class Demo4 {
    public static void main(String[] args) {
        new Hello().sayHello0(new Integer(1));
        new Hello().sayHello1(new Long(1));
        new Hello<String>().sayHello1(new String("1"));
        Hello.sayHello3(new String("sssss"));

    }
}

class Hello<H>{

    public <T> void  sayHello0(T t){
        System.out.println(t.getClass().getCanonicalName());
    }

    //可以用在实例方法上
    public  void  sayHello1(H h){
        System.out.println(h.getClass().getCanonicalName());
    }

    //不可以用在静态方法上，编译不过去
//    public static void  sayHello2(H h){
//        System.out.println(h.getClass().getCanonicalName());
//    }

    public static  <R> void  sayHello3(R r){
        System.out.println(r.getClass().getCanonicalName());
    }
}