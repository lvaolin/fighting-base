package com.dhy.dhytest.limit.atomic;


import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyRateLimiterAtomic {
    private final AtomicInteger counter ;
    private int maxLimit;
    private int timeOut;
    private volatile long lastTime;
    public MyRateLimiterAtomic(int maxLimit,int timeOut){
        counter = new AtomicInteger(maxLimit);
        this.maxLimit = maxLimit;
        this.timeOut = timeOut;
        this.lastTime = System.currentTimeMillis();
    }
    public boolean tryAcquire(){
        long timePass = (System.currentTimeMillis()-lastTime)/1000;
        if (timePass>=timeOut) {
            lastTime = System.currentTimeMillis();
            //刷新计数器
            if (counter.compareAndSet(counter.get(),maxLimit)) {
                System.out.println("刷新计数器成功"+counter.get());
            }else{
                System.out.println("刷新计数器失败");
            }
        }
        if (counter.incrementAndGet()>maxLimit) {
            return false;
        }
        return true;
    }
}

class MyRateLimiterAtomicTest{
    public static void main(String[] args) {
        MyRateLimiterAtomic myRateLimiter = new MyRateLimiterAtomic(100, 1);
        new Thread(()->{
            while (true){
                try {
                    TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(18));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (myRateLimiter.tryAcquire()) {
                    System.out.println("通过");
                }else{
                    System.out.println("被限");
                }
            }
        }).start();
    }
}