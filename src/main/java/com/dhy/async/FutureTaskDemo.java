package com.dhy.async;

import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * @Title FutureTaskDemo
 * @Description
 * @Author lvaolin
 * @Date 2021/3/14 23:20
 **/
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //准备一个futureTask
        //FutureTask 是一个实现了 RunnableFuture接口（Runnable+Future 接口）的类
        RunnableFuture<Boolean> futureTask = new FutureTask<Boolean>(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                System.out.println(Thread.currentThread().getId()+"do something");
                TimeUnit.SECONDS.sleep(10);
                return true;
            }
        });
        //提交到一个线程上或者线程池上执行
        Executors.newSingleThreadExecutor().submit(futureTask);
        //获取执行结果

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(futureTask.get());
            }
        }).start();

        System.out.println(futureTask.get());

        //futureTask.get(1,TimeUnit.SECONDS);
    }
}
