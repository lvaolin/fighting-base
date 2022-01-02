package com.dhy.akka;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Title MyAkkaNode
 * @Description
 * @Author lvaolin
 * @Date 2022/1/2 21:57
 **/

public abstract class AkkaNodeBase {


    private volatile BlockingQueue inbox = new LinkedBlockingDeque<Object>();

    public void set(Object obj){
        try {
            inbox.put(obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Object get(){
        try {
            return inbox.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Object o = get();
                    processData(o);
                }
            }
        });
    }

    protected abstract void processData(Object o);


}
