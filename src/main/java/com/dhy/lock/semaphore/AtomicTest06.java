package com.dhy.lock.semaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 100个线程同时修改共享变量 i  ，每个线程进行 i++ 操作 1万次。
 * 使用Semaphore获取类锁来同步不同线程对i的操作，使其串行化，最终达到 操作的原子性 的目的。
 * 原子操作测试
 * @author lvaolin
 * @create 2019/12/24 7:56 PM
 */
public class AtomicTest06 {
    static Semaphore semaphore= new Semaphore(1);
    static  int i=0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(100);
        for (int j = 0; j <100 ; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    semaphore.acquireUninterruptibly();
                    try {
                        //System.out.println(Thread.currentThread().getName()+":ready");
                        for (int j = 0; j <10000 ; j++) {
                            i++;
                            System.out.println(Thread.currentThread().getName()+":"+i);
                        }
                        System.out.println(Thread.currentThread().getName()+":ok");

                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        cdl.countDown();
                        semaphore.release();
                    }



                }
            }).start();
        }

        cdl.await();
        System.out.println("result:"+i);





    }


}
