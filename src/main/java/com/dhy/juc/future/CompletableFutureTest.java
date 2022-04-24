package com.dhy.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/**
 * 没有返回结果的CompletableFuture
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        CompletableFuture<Void> voidCompletableFuture2 = voidCompletableFuture1.whenComplete((e, t) -> {
            System.out.println("callback1");
        });
        voidCompletableFuture2.whenComplete(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void unused, Throwable throwable) {
                System.out.println("callback2");
            }
        });
        System.out.println("over");
        while (true);
    }
}
