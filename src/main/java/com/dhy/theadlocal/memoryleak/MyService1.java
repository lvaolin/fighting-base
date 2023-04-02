package com.dhy.theadlocal.memoryleak;

import java.io.IOException;

/**
 * @Project fighting-core
 * @Description threadLocalMap内存回收验证
 * @Author lvaolin
 * @Date 2023/4/1 上午11:41
 */
public class MyService1 {

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        MyService1 myService = new MyService1();
        myService.m1();
    }

    public void m1() throws IOException, NoSuchFieldException, IllegalAccessException {
        System.out.println("map初始状态：");
        MyReflectUtil.printThreadLocalMapSize();
        for (int i = 1; i <= 100; i++) {
            ThreadLocal<MyBigObject> tl = new ThreadLocal();
            tl.set(new MyBigObject("set big object"+tl.hashCode()));
        }
        System.out.println("map存储100个条目后：");
        MyReflectUtil.printThreadLocalMapSize();
    }
}
