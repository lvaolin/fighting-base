package com.dhy.lock.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 100个线程同时修改共享变量 i  ，每个线程进行 i++ 操作 1万次。
 * 演示 volatile 关键字解决不了 操作的原子性
 * 原子操作测试
 * @author lvaolin
 * @create 2019/12/24 7:56 PM
 */
public class AtomicTest03 {

    static volatile int i=0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(100);
        for (int j = 0; j <100 ; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //System.out.println(Thread.currentThread().getName()+":ready");
                    for (int j = 0; j <10000 ; j++) {
                        i++;
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                    System.out.println(Thread.currentThread().getName()+":ok");
                    cdl.countDown();
                }
            }).start();
        }

        cdl.await();
        System.out.println("result:"+i);





    }


}
