package com.dhy.lock.syncrinized;

import lombok.SneakyThrows;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Project fighting-core
 * @Description
 * @Author lvaolin
 * @Date 2022/3/26 下午1:53
 */
public class SyncDemo002 {
    int flag = 1;

    public static void main(String[] args) {
        int a = 10,b=3;
        SyncDemo002 syncDemo001 = new SyncDemo002();

        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                while (true)
                System.out.println("a+b="+syncDemo001.add(a,b));
            }
        }).start();
        while (true);
    }

    @SneakyThrows
     int add(int a, int b){
        synchronized(this){
            notifyAll();//无法精确唤醒
            this.wait();//当前线程进入等待队列，并释放锁
        }

        flag = 2;
        return a+b;
    }

    static  {
        synchronized(SyncDemo002.class) {
            System.out.println("test");
        }
    }


}
