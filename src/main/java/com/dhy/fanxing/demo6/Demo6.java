package com.dhy.fanxing.demo6;


/**
 * @Project fighting-core
 * @Description 把成员变量声明成泛型的
 * @Author lvaolin
 * @Date 2022/3/30 下午3:36
 */
public class Demo6 {

    public static void main(String[] args) {
        Hello<String> stringHello = new Hello<>("1111");
        stringHello.sayHello();
    }
}

class Hello<T>{
    private  T t;//只能使用类级别声明的类型，不能自己声明类型
    public Hello(T t){
        this.t = t;
    }
    public  void sayHello(){
        System.out.println(t.getClass().getCanonicalName());
    }
}

class Hello2<T>{
    private  T t;//只能使用类级别声明的类型，不能自己声明类型
    public Hello2(T t){
        this.t = t;
    }
    public  void sayHello(){
        System.out.println(t.getClass().getCanonicalName());
    }
}
