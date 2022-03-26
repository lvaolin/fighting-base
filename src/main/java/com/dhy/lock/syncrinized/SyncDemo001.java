package com.dhy.lock.syncrinized;

import lombok.SneakyThrows;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Project fighting-core
 * @Description 依次交替输出 a+b 、 a-b 、a*b 、a/b 的值
 * @Author lvaolin
 * @Date 2022/3/26 下午1:53
 */
public class SyncDemo001 {
    int flag = 1;

    public static void main(String[] args) {
        int a = 10,b=3;
        SyncDemo001 syncDemo001 = new SyncDemo001();

        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                while (true)
                System.out.println("a+b="+syncDemo001.add(a,b));
            }
        }).start();

        threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                while (true)
                System.out.println("a-b="+syncDemo001.sub(a,b));
            }
        }).start();
        threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    System.out.println("a*b="+syncDemo001.mul(a,b));
            }
        }).start();
        threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    System.out.println("a/b="+syncDemo001.div(a,b));
            }
        }).start();

        while (true);
    }

    @SneakyThrows
    synchronized int add(int a, int b){
        while (flag!=1) {
            this.notifyAll();//无法精确唤醒
            this.wait();//当前线程进入等待队列，并释放锁
        }
        flag = 2;
        return a+b;
    }

    @SneakyThrows
    synchronized int sub(int a, int b){
        while (flag!=2) {
            this.notifyAll();
            this.wait();
        }
        flag = 3;
        return a-b;
    }

    @SneakyThrows
    synchronized int mul(int a, int b){
        while (flag!=3) {
            this.notifyAll();
            this.wait();
        }
        flag = 4;
        return a*b;
    }

    @SneakyThrows
    synchronized int div(int a, int b){
        while (flag!=4) {
            this.notifyAll();
            this.wait();
        }
        flag = 1;
        return a/b;
    }
}
