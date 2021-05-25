package com.dhy.thread;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Project fighting-core
 * @Description 如何终止一个在线程池中运行的任务？
 * @Author lvaolin
 * @Date 2021/5/25 22:49 下午
 */
public class Demo11 {
    static ExecutorService service = Executors.newFixedThreadPool(5);
    public static void main(String[] args) throws IOException, InterruptedException {
        long startTime = System.currentTimeMillis();
        Future<?> future = service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("愉快的开始");
                Thread.currentThread().stop();
                System.out.println("悲剧的终止");
            }
        });
        TimeUnit.MILLISECONDS.sleep(1000);
        //System.out.println("发送中断信号----");
        //取消任务，参数true决定了即使任务已经开始运行，也会向任务发中断信号，
        // 但是不能保证一定会被中断，和业务代码是否具有中断能力有关
        //future.cancel(true);
        System.in.read();
    }
}
