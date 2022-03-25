package com.dhy.lock.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Title Clent
 * @Description
 * @Author lvaolin
 * @Date 2022/3/19 16:51
 **/
public class Client {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        countDownLatch.countDown();
        countDownLatch.countDown();

        countDownLatch.await();
        countDownLatch.await(1, TimeUnit.SECONDS);
        System.out.println("okl");
    }
}
