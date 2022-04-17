package com.dhy.dhytest.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class LockTest2 {

    public static void main(String[] args) throws Exception{
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Thread(() -> {
            try {
                System.out.println("getParties:" + cyclicBarrier.getParties() + ",getNumberWaiting:" + cyclicBarrier.getNumberWaiting());
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        TimeUnit.SECONDS.sleep(2);

        new Thread(() -> {
            try {
                System.out.println("getParties:" + cyclicBarrier.getParties() + ",getNumberWaiting:" + cyclicBarrier.getNumberWaiting());
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        TimeUnit.SECONDS.sleep(2);

        System.out.println("getParties:"+cyclicBarrier.getParties()+",getNumberWaiting:"+cyclicBarrier.getNumberWaiting());
        cyclicBarrier.await();
        System.out.println("okl getParties:"+cyclicBarrier.getParties()+",getNumberWaiting:"+cyclicBarrier.getNumberWaiting());
    }
}
