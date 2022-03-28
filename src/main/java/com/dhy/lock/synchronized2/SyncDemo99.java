package com.dhy.lock.synchronized2;

import lombok.SneakyThrows;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/3/28 下午12:09
 */
public class SyncDemo99 {
     Object lock = new Object();
    @SneakyThrows
    public  int mul(int a, int b){
        int c;
        synchronized(SyncDemo99.class){
                lock.notifyAll();
                lock.wait();
        }
        return a*b;
    }

    public static void main(String[] args) {
        SyncDemo99 syncDemo99 = new SyncDemo99();
        System.out.println(syncDemo99.mul(3, 7));
    }
}
