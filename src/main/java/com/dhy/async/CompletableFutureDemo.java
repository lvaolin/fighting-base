package com.dhy.async;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @Title FutureTaskDemo
 * @Description
 * @Author lvaolin
 * @Date 2021/3/14 23:20
 **/
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("--completable future   1---------");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },executorService);

        voidCompletableFuture.thenRun(() -> {
            System.out.println("----2----");
        }).get();




        CompletableFuture<String> c2 = CompletableFuture.supplyAsync(()->{
            System.out.println("3");
            return "okl";
        },executorService);
        String s2 = c2.get();
        c2.thenRun(() -> {
            System.out.println("----4----");
        }).get();


    }
}
