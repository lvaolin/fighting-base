package com.dhy.designpatterns.mediator.demo1;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/14 上午9:25
 */
public class TimerTest {
    public static void main(String[] args)  {
        //定时器
        Timer timer = new Timer();
        //定时任务
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("北京时间：" + LocalDateTime.now().toString());
            }
        };
        //向定时器注册，进入调度任务队列,按固定任务之间间隔执行（上次执行完毕后计时）
        timer.schedule(timerTask,0,1000);
        //向定时器注册，进入调度任务队列,按固定频率执行（上次执行开始前计时）
        timer.scheduleAtFixedRate(timerTask,0,1000);
        //timerTask.cancel();//取消当前任务，将任务标记为取消状态
        //timerTask.scheduledExecutionTime();//上次执行时间
        //timer.purge();//清理队列中已经取消的任务
        //timer.cancel();//终止调度线程，清空队列中所有任务
    }
}
