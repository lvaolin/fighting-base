package com.dhy.juc.threadpool;

import java.util.concurrent.*;

public class ThreadpoolTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool(100);
        Future<Integer> t1 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });

        Future<Integer> t2 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        });

        System.out.println(t1.get() + t2.get());
    }
}
