package com.dhy.lock.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title Client
 * @Description
 * @Author lvaolin
 * @Date 2022/3/19 17:07
 **/
public class Client {
    ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {

        Client client = new Client();

        new Thread(()->client.method1()).start();
        new Thread(()->client.method1()).start();

    }

    public void method1(){
        reentrantLock.lock();
        try {
            System.out.println("获取锁成功");
            int count = 5;
            while (count-->0){
                System.out.println(Thread.currentThread().getId());
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
            System.out.println("释放锁成功");

        }


    }


    public synchronized void method2(){

    }
}
