package com.dhy.lock.readwritelock;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/4/9 下午1:15
 */
public class Client01 {
    public static void main(String[] args) throws Exception {
        Config config = new Config();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        for (int i = 0; i < 3; i++) {
            threadFactory.newThread(()->{
                System.out.println(config.getLimit());
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
        ReadWriteLock lock = new ReentrantReadWriteLock();
        //Lock readLock = lock.readLock();
        Lock writeLock = lock.writeLock();

        //读锁 不支持 newCondition
        //Condition readLockCondition1 = readLock.newCondition();

        //写锁 支持 newCondition（需要独占模式才行）
        Condition writeLockCondition1 = writeLock.newCondition();
        Condition writeLockCondition2 = writeLock.newCondition();

        private AtomicInteger limit = new AtomicInteger(0);
        public int getLimit()  {
            writeLock.lock();
            try {
                while (this.limit.intValue()<10) {
                    System.out.println("writeLockCondition1 进入等待");
                    writeLockCondition1.await();
                }
                while (this.limit.intValue()<20) {
                    System.out.println("writeLockCondition2 进入等待");
                    writeLockCondition2.await();
                }
            }catch (InterruptedException t){
                t.printStackTrace();
            }finally {
                writeLock.unlock();
            }

            return limit.intValue();
        }
        public void setLimit(int limit){
            this.limit.set(limit);
            writeLock.lock();
            try {
                if (limit>=10&&limit<20) {
                    System.out.println("writeLockCondition1 被唤醒");
                    writeLockCondition1.signalAll();
                }
                if (limit>=20) {
                    System.out.println("writeLockCondition2 被唤醒");
                    writeLockCondition2.signalAll();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                writeLock.unlock();
            }

            return;

        }
    }
}
