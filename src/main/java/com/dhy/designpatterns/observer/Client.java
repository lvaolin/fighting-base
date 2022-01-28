package com.dhy.designpatterns.observer;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * 模拟spring容器 启动流程 产生事件
 */
public class Client {


    public static void main(String[] args) throws InterruptedException {

        //注册监听者
         ArrayList<EventProcessor> eventProcessors = new ArrayList<>();
        {
            eventProcessors.add(new MyObserver1());
            eventProcessors.add(new MyObserver2());
        }
        //异步广播：事件
        EventBroadcast.broadcast(eventProcessors,MyEvent.starting);
        EventBroadcast.broadcast(eventProcessors,MyEvent.started);
        EventBroadcast.broadcast(eventProcessors,MyEvent.stoping);
        EventBroadcast.broadcast(eventProcessors,MyEvent.stoped);

        new CountDownLatch(1).await();
    }

}
