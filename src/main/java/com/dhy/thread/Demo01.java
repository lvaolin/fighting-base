package com.dhy.thread;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Project fighting-core
 * @Description  如何终止一个正在sleep的线程？
 * @Author lvaolin
 * @Date 2021/5/25 5:26 下午
 */
public class Demo01 {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(System.currentTimeMillis());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("愉快的开始");
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("愉快的结束");
                } catch (InterruptedException e) {
                    System.out.println("我被终止了"+System.currentTimeMillis());
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println("over");
        System.in.read();
    }
}
