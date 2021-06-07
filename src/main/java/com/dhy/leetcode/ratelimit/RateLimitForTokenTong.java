package com.dhy.leetcode.ratelimit;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 令牌桶算法
 */
public class RateLimitForTokenTong {

    /**
     * 令牌桶最大容量
     */
    private static volatile int max=500;
    /**
     * 投放令牌的速度
     */
    private static volatile int rate=100;

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    /**
     * 令牌桶自身
     */
    private static AtomicInteger tong = new AtomicInteger(0);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true){
                    Lock lock = readWriteLock.writeLock();
                    lock.lock();//保证以下步骤的原子性
                    int i = tong.addAndGet(rate);
                    if (i>max) {
                        tong.set(max);
                    }
                    lock.unlock();

                    TimeUnit.SECONDS.sleep(1);
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    Lock lock = readWriteLock.readLock();
                    lock.lock();
                    int i = tong.get();
                    if (i>0) {
                        System.out.println("pass");
                    }else{
                        System.out.println("no pass");
                    }
                    lock.unlock();
                }
            }
        }).start();
    }
}
