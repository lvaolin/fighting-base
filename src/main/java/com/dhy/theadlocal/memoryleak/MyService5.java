package com.dhy.theadlocal.memoryleak;

import java.io.IOException;

/**
 * @Project fighting-core
 * @Description threadLocalMap内存回收验证
 * @Author lvaolin
 * @Date 2023/4/1 上午11:41
 */
public class MyService5 {

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        MyService5 myService = new MyService5();
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

        System.gc();
        ThreadLocal<MyBigObject> tl = new ThreadLocal();
        //tl.get();
        //tl.set(new MyBigObject("set big object"+tl.hashCode()));
        tl.remove();
        System.out.println("GC后进行remove操作后：");
        MyReflectUtil.printThreadLocalMapSize();
    }
}
