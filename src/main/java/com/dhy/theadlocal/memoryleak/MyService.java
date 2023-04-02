package com.dhy.theadlocal.memoryleak;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.concurrent.ThreadFactory;

/**
 * @Project fighting-core
 * @Description threadLocalMap内存回收验证
 * @Author lvaolin
 * @Date 2023/4/1 上午11:41
 */
public class MyService {

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        MyService myService = new MyService();
        myService.m1();
    }

    public void m1() throws IOException, NoSuchFieldException, IllegalAccessException {
        System.out.println("map初始状态：");
        printThreadLocalMapSize();
        for (int i = 1; i <= 100; i++) {
            ThreadLocal<MyBigObject> tl = new ThreadLocal();
            tl.set(new MyBigObject("set big object"+tl.hashCode()));
            System.out.println(tl.get());
            //if (i%10==0)System.gc();
        }
        System.out.println("map存储100个条目后：");
        printThreadLocalMapSize();

//        while (true){
//            System.gc();
//            printThreadLocalMapSize();
//            ThreadLocal<MyBigObject> tl = new ThreadLocal();
//            tl.get();
//            //tl.set(new MyBigObject("set big object"+tl.hashCode()));
//            //tl.remove();
//            printThreadLocalMapSize();
//        }
    }

    private void printThreadLocalMapSize() throws NoSuchFieldException, IllegalAccessException {
        Thread thread = Thread.currentThread();
        Field threadLocalsField = Thread.class.getDeclaredField("threadLocals");
        threadLocalsField.setAccessible(true);
        Object threadLocals = threadLocalsField.get(thread);

        Field tableField = threadLocals.getClass().getDeclaredField("table");
        tableField.setAccessible(true);
        Object entryArr = tableField.get(threadLocals);
        int length = Array.getLength(entryArr);//threadLocalMap  length

        Field sizeField = threadLocals.getClass().getDeclaredField("size");
        sizeField.setAccessible(true);
        Object size = sizeField.get(threadLocals);//threadLocalMap  size
        System.out.println("threadLocalMap：length->"+length+",size->"+size);
    }


}
