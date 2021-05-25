package com.dhy.thread;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Project fighting-core
 * @Description 如何终止一个正常运行的程序？
 * @Author lvaolin
 * @Date 2021/5/25 22:07 下午
 */
public class Demo09 {
    public static void main(String[] args) throws IOException, InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(Thread.interrupted()){
                        System.out.println("我被中断了1，但我不想中断");
                    }
                    System.out.println("do something1");
                    if(Thread.interrupted()){
                        System.out.println("我被中断了2，不能继续向下走了");
                        return;
                    }
                    System.out.println("do something2");
                    if(Thread.interrupted()){
                        System.out.println("我被中断了3");
                        return;
                    }
                    System.out.println("do something3");
                }

            }
        });
        thread.start();
        TimeUnit.MILLISECONDS.sleep(1);
        System.out.println("发送中断信号----");
        thread.interrupt();
        System.in.read();
    }
}
