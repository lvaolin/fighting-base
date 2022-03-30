package com.dhy.fanxing.demo2;

/**
 * @Project fighting-core
 * @Description 实例方法级别的泛型，要在方法前面进行声明(这个声明和返回值无关，不要认为是返回值)
 * @Author lvaolin
 * @Date 2022/3/30 上午11:22
 */
public class Demo2 {
    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.sayHello1(new Integer(1));
        hello.sayHello2(new Long(2));
        hello.sayHello3("aaa");
    }
}

class Hello{
    //每个方法自己要声明下 <T>，这个和返回值无关
    public  <T> void  sayHello1(T t){
        System.out.println(t.getClass().getCanonicalName());
    }

    public  <R> void  sayHello2(R r){
        System.out.println(r.getClass().getCanonicalName());
    }
    //返回值也用泛型
    public  <A> A  sayHello3(A a){
        System.out.println(a.getClass().getCanonicalName());
        return a;
    }
}