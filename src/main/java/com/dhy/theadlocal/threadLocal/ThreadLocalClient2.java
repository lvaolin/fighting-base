package com.dhy.theadlocal.threadLocal;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @Project fighting-core
 * @Description 手撕类似ThreadLocal的功能，自定义MyMap 实现 和线程绑定的 变量传递， 问题是线程退出后，如何释放map中的资源？
 * @Author lvaolin
 * @Date 2022/4/24 下午2:11
 */
public class ThreadLocalClient2 {
    static MyMap<String, String> map = new MyMap<String, String>();

    public static void main(String[] args) {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadFactory.newThread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    map.put("name" + i, Thread.currentThread().getName() + "zhangsan" + i);
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + ":" + map.get("name" + i));
                }
            }
        }).start();

        threadFactory.newThread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    map.put("name" + i, Thread.currentThread().getName() + "lishi" + i);
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + ":" + map.get("name" + i));
                }
            }
        }).start();
        while (true) ;
    }
}

class MyMap<K, V> {
    private Map<Thread, Map<K, V>> threadMap = new ConcurrentHashMap<>();

    /**
     * 向线程上注册资源
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        Map map = threadMap.get(Thread.currentThread());
        if (map == null) {
            threadMap.put(Thread.currentThread(), new HashMap());
        }
        map = threadMap.get(Thread.currentThread());
        map.put(key, value);
    }

    /**
     * 获取线程上key对应的资源
     * @param key
     * @return
     */
    public V get(K key) {
        Map<K, V> map = threadMap.get(Thread.currentThread());
        if (map == null) {
            return null;
        }
        return map.get(key);
    }

    /**
     * 释放线程上key对应的资源
     * @param key
     * @return
     */
    public V remove(K key) {
        return threadMap.get(Thread.currentThread()).remove(key);
    }

    /**
     * 释放线程上的资源
     */
    public void remove() {
        threadMap.remove(Thread.currentThread());
    }
}