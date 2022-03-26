package com.dhy.lock.syncrinized;

import lombok.SneakyThrows;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Project fighting-core
 * @Description synchronized必须在获取对象锁的情况下才能和wait、notify、notifyAll配合使用
 * @Author lvaolin
 * @Date 2022/3/26 下午1:53
 */
public class SyncDemo003 {
    final Object lock = new Object();

    public static void main(String[] args) {
        int a = 10,b=3;
        SyncDemo003 syncDemo001 = new SyncDemo003();

        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                while (true)
                System.out.println("a+b="+syncDemo001.add(a,b));
            }
        }).start();
        threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    System.out.println("a+b="+syncDemo001.add(a,b));
            }
        }).start();
        while (true);
    }

    @SneakyThrows
     int add(int a, int b){
        synchronized (lock){
            lock.notifyAll();//无法精确唤醒
            lock.wait();//当前线程进入等待队列，并释放锁
        }
        return a+b;
    }



}
