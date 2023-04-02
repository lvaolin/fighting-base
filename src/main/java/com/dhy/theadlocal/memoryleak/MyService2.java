package com.dhy.theadlocal.memoryleak;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * @Project fighting-core
 * @Description threadLocalMap内存回收验证
 * @Author lvaolin
 * @Date 2023/4/1 上午11:41
 */
public class MyService2 {

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        MyService2 myService = new MyService2();
        myService.m1();
    }

    public void m1() throws IOException, NoSuchFieldException, IllegalAccessException {
        System.out.println("map初始状态：");
        MyReflectUtil.printThreadLocalMapSize();
        for (int i = 1; i <= 100; i++) {
            ThreadLocal<MyBigObject> tl = new ThreadLocal();
            tl.set(new MyBigObject("set big object"+tl.hashCode()));
            //x越小，gc越频繁
            // threadlocal弱引用对象回收越及时，
            // threadlocalMap回收越及时（前面文章讲了什么情况下触发回收）
            int x = 20;
            if (i%x==0)System.gc();

        }
        System.out.println("map存储100个条目后：");
        MyReflectUtil.printThreadLocalMapSize();

    }



}
