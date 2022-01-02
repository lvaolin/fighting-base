package com.dhy.akka;

import java.util.concurrent.TimeUnit;

/**
 * @Title MessageSender
 * @Description
 * @Author lvaolin
 * @Date 2022/1/2 22:24
 **/
public class MessageSender {

    public void call(String p){
        //async http client
        //callback
        while (true){
            AkkaListener1.getInstance().set("session id"+System.currentTimeMillis());
            System.out.println("set ok");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
