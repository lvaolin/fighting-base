package com.dhy.juc.lock;

import java.util.concurrent.CountDownLatch;

public class LockTest1 {

    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(2);
        System.out.println(countDownLatch.getCount());//2
        countDownLatch.countDown();
        System.out.println(countDownLatch.getCount());//1
        countDownLatch.countDown();//同一个线程可以减去多次
        System.out.println(countDownLatch.getCount());//0
        countDownLatch.countDown();//同一个线程可以减去多次
        System.out.println(countDownLatch.getCount());//0
        countDownLatch.await();
        countDownLatch.await();
        countDownLatch.await();
        countDownLatch.await();
        System.out.println("ooool");
    }
}
