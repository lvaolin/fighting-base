package com.dhy.thread;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Project fighting-core
 * @Description  如何终止一个正在block的线程？
 * @Author lvaolin
 * @Date 2021/5/25 5:26 下午
 */
public class Demo05 {
    static Object lock = new Object();
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(System.currentTimeMillis());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("1愉快的开始");
                    synchronized (lock){
                        lock.wait();
                    }
                    System.out.println("1愉快的结束");
                } catch (InterruptedException e) {
                    System.out.println("1我被终止了"+System.currentTimeMillis());
                }
            }
        });
        thread.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("2愉快的开始");
                    synchronized (lock){
                        lock.wait();
                    }
                    System.out.println("2愉快的结束");
                } catch (InterruptedException e) {
                    System.out.println("2我被终止了"+System.currentTimeMillis());
                }
            }
        });
        //thread2.start();
        TimeUnit.SECONDS.sleep(1);
        thread2.interrupt();

        System.in.read();
    }
}
