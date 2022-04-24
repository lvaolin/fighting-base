package com.dhy.juc.limit.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 *  依靠客户线程刷新重置  许可
 */
public class MyRateLimiter2 {
    private final Semaphore semaphore ;
    private volatile long lastTime ;
    private int timeOut;
    private int maxLimit;
    public MyRateLimiter2(int maxLimit,int timeOut){
        semaphore = new Semaphore(maxLimit);
        lastTime = System.currentTimeMillis();
        this.maxLimit = maxLimit;
        this.timeOut = timeOut;
    }
    public boolean tryAcquire(){
        long timePass = (System.currentTimeMillis()-lastTime)/1000;
        //System.out.println(timePass);
        if (timePass>=timeOut) {
            lastTime = System.currentTimeMillis();
            semaphore.release(maxLimit-semaphore.availablePermits());
            System.out.println("已刷新："+semaphore.availablePermits());
        }
        return semaphore.tryAcquire();
    }

}

class MyRateLimiterTest2{
    public static void main(String[] args) {
        MyRateLimiter2 myRateLimiter = new MyRateLimiter2(100, 1);
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