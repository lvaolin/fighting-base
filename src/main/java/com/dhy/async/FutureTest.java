package com.dhy.async;

import lombok.SneakyThrows;
import sun.misc.Unsafe;

import java.util.concurrent.*;

/**
 * @Title FutureTest
 * @Description
 * @Author lvaolin
 * @Date 2022/3/20 10:43
 **/
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Future<?> future = Executors.newSingleThreadExecutor().submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                //TimeUnit.SECONDS.sleep(10);
                System.out.println("aaaaa");
            }
        });
        //返回的是一个FutureTask对象
        future.get();
        method1();
        System.gc();
    }

    static void  method1(){
        Hello hello = new Hello();
        hello.sayHello();
        hello.sayHello();
        hello.sayHello();
    }

}




class Hello{
    int i=0;
    void sayHello(){
        i++;
        System.out.println("hello");



    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("hello 了几次："+i);
        super.finalize();
    }
}