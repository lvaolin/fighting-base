package com.dhy.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 串行编排任务  t1，t2，t3
 * t1依赖用户输入，t2依赖t1的输出结果，t3依赖t2的输出结果，t3输出被客户打印
 */
public class CompletableFutureTest1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final int a = 1;

        CompletableFuture<Integer> t1 = CompletableFuture.supplyAsync(()->{
            sleep1();
            System.out.println("t1");
            return a+1;
        });

        CompletableFuture<Integer> t2 = t1.thenApply((x) -> {
            sleep1();
            System.out.println("t2");
            return x + 1;
        });
        CompletableFuture<Integer> t3 = t2.thenApply((x) -> {
            sleep1();
            System.out.println("t3");
            return x + 1;
        });


        System.out.println("over1");
        System.out.println("t3="+t3.get());
        System.out.println("over2");
        while (true);
    }

    static void sleep1(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
