package com.dhy.dhytest.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 手动设定 结果
 * 这样就可以实现  线程之间的结果传递 了
 */
public class CompletableFutureTest4 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = new CompletableFuture<>();

        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("task 正在执行-----");
                result.complete("true");//手动设定执行结果
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程结束");
            }
        }).start();

        System.out.println("task结果:"+result.get());
        System.out.println("task 执行结束-----");
        while (true);
    }

}
