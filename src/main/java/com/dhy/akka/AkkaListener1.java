package com.dhy.akka;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title AkkaListener1
 * @Description
 * @Author lvaolin
 * @Date 2022/1/2 22:07
 **/
public class AkkaListener1 extends AkkaNodeBase {

    static AkkaListener1 akkaListener1 = new AkkaListener1();

    public static AkkaListener1 getInstance(){
        return akkaListener1;
    }

    @Override
    protected void processData(Object o) {
        System.out.println("处理："+o.toString());
    }




}
