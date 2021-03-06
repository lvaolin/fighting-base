package com.dhy.juc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替输出 字母和数字----------------------------
 */
public class Demo4 {

        static Thread t1 = null;
        static Thread t2 = null;
        static Lock lock = new ReentrantLock();
        public static void main(String[] args) {

           t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        lock.lock();
                        print1();
                        lock.unlock();
                        synchronized (Demo4.class){
                            Demo4.class.notify();
                            Demo4.class.wait();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

         t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        lock.lock();
                        print2();
                        lock.unlock();
                        synchronized (Demo4.class){
                            Demo4.class.notify();
                            Demo4.class.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        t1.start();
        t2.start();
    }


    public static void print1() throws InterruptedException {
                System.out.println("a");
    }
    public static void print2() throws InterruptedException {
            System.out.println("1");
    }

}
