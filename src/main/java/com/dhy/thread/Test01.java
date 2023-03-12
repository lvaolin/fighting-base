package com.dhy.thread;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * @Project fighting-core
 * @Description 线程退出后Thread对象会被释放吗？
 * @Author lvaolin
 * @Date 2023/3/12 下午12:14
 */
public class Test01 {
    static  ThreadLocal<String>  threadLocal = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {

        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                //newThreadLocal();
                //staticThreadLocal();
                while (true);
            }
        });
        thread.setName("lval");
        thread.start();
        thread = null;
        System.gc();
        threadLocal.set("main big Object");
        System.out.println(threadLocal.get());
        while (true){
            //System.gc();
            //System.out.println(threadLocal.get());
        }
    }

    private static void newThreadLocal() {
        ThreadLocal<String> threadLocal = new ThreadLocal();
        threadLocal.set("new big object");
        System.out.println(threadLocal.get());
        threadLocal.remove();

    }

    private static void staticThreadLocal(){
        threadLocal.set("static big object");
        System.out.println(threadLocal.get());
        threadLocal.remove();
    }
}
