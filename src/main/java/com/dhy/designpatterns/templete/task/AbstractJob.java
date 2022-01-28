package com.dhy.designpatterns.templete.task;

import java.time.LocalDateTime;

/**
 * @Title AbstractJob
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 18:31
 **/
public abstract class AbstractJob {

    public final void templeteMethod(){
        Object[] objects = queryTask();
        System.out.println("查询到任务"+objects.length+"条");
        for (Object object : objects) {
            try {
                System.out.println("开始处理任务："+object);
                processData(object);
                System.out.println("任务处理结束："+object);
            }catch (Throwable t){
                System.out.println("任务"+object+"异常："+t.getMessage());
            }

        }
    }

    abstract Object[] queryTask();

    abstract void processData(Object data);


}
