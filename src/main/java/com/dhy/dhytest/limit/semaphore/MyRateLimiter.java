package com.dhy.dhytest.limit.semaphore;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 靠额外线程刷新重置  许可
 */
public class MyRateLimiter {
    private final Semaphore semaphore ;
    public MyRateLimiter(int maxLimit,int timeLimit){
        semaphore = new Semaphore(maxLimit);
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{
            System.out.println("可用许可："+semaphore.availablePermits());
            semaphore.release(maxLimit-semaphore.availablePermits());
            System.out.println("重置许可："+semaphore.availablePermits());
        },0L,timeLimit, TimeUnit.SECONDS);
    }
    public boolean tryAcquire(){
        return semaphore.tryAcquire();
    }

}

class MyRateLimiterTest{
    public static void main(String[] args) {
        MyRateLimiter myRateLimiter = new MyRateLimiter(100, 1);
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