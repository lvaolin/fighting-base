package com.dhy.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Project fighting-core
 * @Description 固定线程数量的线程池实现
 * @Author lvaolin
 * @Date 2021/5/26 1:21 下午
 */
public class Demo01 {
    //下面这几种线程池的实现基础都是ThreadPoolExecutor 线程池实现类
    static ExecutorService executorService1 = Executors.newFixedThreadPool(10);
    static ExecutorService executorService2 = Executors.newCachedThreadPool();
    static ExecutorService executorService3 = Executors.newSingleThreadExecutor();
    static ExecutorService executorService4 = Executors.newScheduledThreadPool(10);
    static ExecutorService executorService5 = Executors.newSingleThreadScheduledExecutor();
    //它的实现比较特殊用的ForkJoinPool 线程池实现类
    static ExecutorService executorService6 = Executors.newWorkStealingPool();


    public static void main(String[] args) {
        executorService1.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

}
