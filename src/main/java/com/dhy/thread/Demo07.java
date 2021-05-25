package com.dhy.thread;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Project fighting-core
 * @Description 如何终止一个死循环？
 * @Author lvaolin
 * @Date 2021/5/25 22:07 下午
 */
public class Demo07 {
    public static void main(String[] args) throws IOException, InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true && !Thread.currentThread().isInterrupted()) {
                    System.out.println("愉快的开始");
                    System.out.println("愉快的结束");
                }
                System.out.println("我被终止了,运行了" + (System.currentTimeMillis()-startTime)+"ms");
            }
        });
        thread.start();
        TimeUnit.MILLISECONDS.sleep(1);
        System.out.println("发送中断信号----");
        thread.interrupt();
        System.in.read();
    }
}
