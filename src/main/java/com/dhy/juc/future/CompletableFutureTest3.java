package com.dhy.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * thenCompose 的运用
 *
 * 并行编排任务  t1，t2，并行执行
 * t3依赖t1和t2的输出结果，
 * t3输出被客户打印
 */
public class CompletableFutureTest3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> t1 = CompletableFuture.supplyAsync(()->{
            sleep1();
            System.out.println("t1");
            return 100;
        });

        CompletableFuture<String> t2 =t1.thenCompose(i->{
            return CompletableFuture.supplyAsync(() -> {
                sleep1();
                System.out.println("t2");
                return i+200+"int 转 string 了";
            });
        });




        System.out.println("over1");
        System.out.println("t2="+t2.get());
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
