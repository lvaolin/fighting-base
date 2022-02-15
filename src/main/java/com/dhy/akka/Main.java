package com.dhy.akka;

import java.util.concurrent.TimeUnit;

/**
 * @Title Client1
 * @Description
 * @Author lvaolin
 * @Date 2022/1/2 22:31
 **/
public class Main {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                new MessageSender().call("hello--");
            }
        }).start();


        try {
            TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
