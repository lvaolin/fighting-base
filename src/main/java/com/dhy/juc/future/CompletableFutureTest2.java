package com.dhy.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

/**
 * 并行编排任务  t1，t2，并行执行
 * t3依赖t1和t2的输出结果，
 * t3输出被客户打印
 *
 * thenCombine 的运用
 *
 */
public class CompletableFutureTest2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {



        CompletableFuture<Integer> t1 = CompletableFuture.supplyAsync(()->{
            sleep1();
            System.out.println("t1");
            return 100;
        });

        CompletableFuture<Integer> t2 = CompletableFuture.supplyAsync(() -> {
            sleep1();
            System.out.println("t2");
            return 200;
        });

        CompletableFuture<Integer> t3 = CompletableFuture.supplyAsync(() -> {
            sleep1();
            System.out.println("t3");
            return 300;
        });

        CompletableFuture<Integer> t4 = CompletableFuture.supplyAsync(() -> {
            sleep1();
            System.out.println("t4");
            return 400;
        });

        CompletableFuture<Integer> t = t1.thenCombine(t2, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer t1r, Integer t2r) {
                sleep1();
                return t1r * t2r;
            }
        }).thenCombine(t3,(t12r,t3r)->{
            sleep1();
            return t12r*t3r;
        }).thenCombine(t4,(t123r,t4r)->{
            sleep1();
            return t123r+t4r;
        });


        System.out.println("over1");
        System.out.println("t="+t.get());
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
