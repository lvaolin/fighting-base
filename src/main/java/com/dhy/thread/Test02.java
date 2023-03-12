package com.dhy.thread;

import lombok.SneakyThrows;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Project fighting-core
 * @Description 线程退出后Thread对象会被释放吗？
 * @Author lvaolin
 * @Date 2023/3/12 下午12:14
 */
public class Test02 {
    static  ThreadLocal<String>  threadLocal = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        threadLocal.set("main big Object");
        System.out.println(threadLocal.get());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("sub thread big Object");
                System.out.println(threadLocal.get());
            }
        });


        Field threadLocals = thread.getClass().getDeclaredField("threadLocals");
        threadLocals.setAccessible(true);
        Class<?> fieldType = threadLocals.getType();
        Object threadLocalMap = threadLocals.get(thread);
        Field tableField = fieldType.getDeclaredField("table");
        tableField.setAccessible(true);
        Object entryArr = tableField.get(threadLocalMap);
        int length = Array.getLength(entryArr);
        for (int i = 0; i < length; i++) {
            Object o = Array.get(entryArr, i);
            if (o==null) {
                continue;
            }
            try {
                Field valueResult = o.getClass().getDeclaredField("value");
                valueResult.setAccessible(true);
                Object invoke = valueResult.get(valueResult);
                System.out.println("xxxx:"+(String)invoke);
            }catch (Exception e){

            }

        }





        while (true){
            //System.gc();
            //System.out.println(threadLocal.get());
        }
    }


}
