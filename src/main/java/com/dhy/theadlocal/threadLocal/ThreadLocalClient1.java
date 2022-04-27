package com.dhy.theadlocal.threadLocal;

import lombok.SneakyThrows;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @Project fighting-core
 * @Description 简单的ThreadLocal用法测试
 * @Author lvaolin
 * @Date 2022/4/24 下午2:11
 */
public class ThreadLocalClient1 {
    static ThreadLocal<String>  a = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadFactory.newThread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true){
                    a.set(Thread.currentThread().getName()+"zhangsan");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName()+"："+a.get());
                }

            }
        }).start();

        threadFactory.newThread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true){

                    a.set(Thread.currentThread().getName()+"zhangsan");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName()+"："+a.get());
                }

            }
        }).start();

        while (true);


    }
}
