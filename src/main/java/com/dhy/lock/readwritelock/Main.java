package com.dhy.lock.readwritelock;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        readLock.lock();
        threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("获取写锁中----");
                writeLock.lock();
                System.out.println("获取写锁成功");
                writeLock.unlock();
                System.out.println("写锁释放");
            }
        }).start();


        threadFactory.newThread(()->{
            readLock.lock();
            readLock.lock();
            readLock.lock();
            readLock.lock();
            readLock.lock();
            readLock.lock();
            System.out.println("读锁数量"+reentrantReadWriteLock.getReadLockCount());
        }).start();

        TimeUnit.SECONDS.sleep(3);
        readLock.unlock();
        System.out.println("读锁数量"+reentrantReadWriteLock.getReadLockCount());


    }

}
