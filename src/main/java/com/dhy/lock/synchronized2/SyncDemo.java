package com.dhy.lock.synchronized2;

import lombok.SneakyThrows;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Project fighting-core
 * @Description 交替调用 add和sub方法
 * @Author lvaolin
 * @Date 2022/3/28 上午9:22
 */
public class SyncDemo {
    private volatile int flag = 1;



    @SneakyThrows
    public synchronized int add(int a, int b){
        while (flag!=1){
            this.notifyAll();
            this.wait();
        }
        flag = 2;
        return a+b;
    }
    @SneakyThrows
    public synchronized  int sub(int a, int b){
        while (flag!=2){
            this.notifyAll();
            this.wait();
        }
        flag = 1;
        return a-b;
    }

    public static void main(String[] args) {
        final SyncDemo syncDemo = new SyncDemo();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadFactory.newThread(()->{
            while (true){
                System.out.println(syncDemo.add(2,1));
            }
        }).start();

        threadFactory.newThread(()->{
            while (true){
                System.out.println(syncDemo.sub(2,1));
            }
        }).start();

        while (true);
    }
}


