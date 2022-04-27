package com.dhy.theadlocal.transmittableThreadLocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Project fighting-core
 * @Description transmittableThreadLocal框架测试 解决 线程池数据传递问题
 * 通过修饰 Runnable和Callable接口解决
 * @Author lvaolin
 * @Date 2022/4/27
 */
public class ThreadLocalClient2 {
    static TransmittableThreadLocal<String> ttl = new TransmittableThreadLocal<>();

    static ExecutorService executorService = Executors.newFixedThreadPool(1);
    static {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("预热，产生核心线程");
            }
        });
    }

    public static void main(String[] args) {
        ttl.set("zhangsan");

        //复用核心线程
        executorService.submit(TtlRunnable.get(new Runnable() {
            @Override
            public void run() {
                System.out.println("未使用代理："+ ttl.get());
            }
        }));

        while (true);


    }
}
