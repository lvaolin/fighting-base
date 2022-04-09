package com.dhy.lock.reentrantlock;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Project fighting-core
 * @Description ReentrantLock  与  Condition 配合使用
 * @Author lvaolin
 * @Date 2022/4/9 下午1:15
 */
public class Client02 {
    public static void main(String[] args) throws Exception{
        Config config = new Config();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        for (int i = 0; i < 5; i++) {
            threadFactory.newThread(()->{
                System.out.println(config.getLimit1());
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            threadFactory.newThread(()->{
                System.out.println(config.getLimit2());
            }).start();
        }

        TimeUnit.SECONDS.sleep(5);

        threadFactory.newThread(()->{
            config.setLimit(10);
        }).start();

        TimeUnit.SECONDS.sleep(5);

        threadFactory.newThread(()->{
            config.setLimit(20);
        }).start();

        while (true);
    }


    static class Config{
        Lock lock = new ReentrantLock();

        Condition lockCondition1 = lock.newCondition();
        Condition lockCondition2 = lock.newCondition();

        private AtomicInteger limit = new AtomicInteger(0);
        public int getLimit1()  {
            lock.lock();
            try {
                while (this.limit.intValue()<10) {
                    System.out.println("lockCondition1 进入等待");
                    lockCondition1.await();
                }
            }catch (InterruptedException t){
                t.printStackTrace();
            }finally {
                lock.unlock();
            }

            return limit.intValue();
        }
        public int getLimit2()  {
            lock.lock();
            try {
                while (this.limit.intValue()<20) {
                    System.out.println("lockCondition2 进入等待");
                    lockCondition1.await();
                }
            }catch (InterruptedException t){
                t.printStackTrace();
            }finally {
                lock.unlock();
            }

            return limit.intValue();
        }
        public void setLimit(int limit){
            this.limit.set(limit);
            lock.lock();
            try {
                if (limit>=10&&limit<20) {
                    System.out.println("lockCondition1 被唤醒");
                    lockCondition1.signalAll();
                }
                if (limit>=20) {
                    System.out.println("lockCondition2 被唤醒");
                    lockCondition1.signalAll();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

            return;

        }
    }
}
