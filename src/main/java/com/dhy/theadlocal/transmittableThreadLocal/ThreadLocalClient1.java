package com.dhy.theadlocal.transmittableThreadLocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.SneakyThrows;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Project fighting-core
 * @Description transmittableThreadLocal框架测试解决  new Thread 数据传递问题
 * @Author lvaolin
 * @Date 2022/4/27
 */
public class ThreadLocalClient1 {
    static TransmittableThreadLocal<String> ttl = new TransmittableThreadLocal<>();


    public static void main(String[] args) {
        ttl.set("zhangsan");
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadFactory.newThread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                    System.out.println(Thread.currentThread().getName()+"："+ttl.get());
            }
        }).start();

        while (true);


    }
}
