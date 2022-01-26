package com.dhy.designpatterns.command.demo1;

/**
 * @Title Receiver1
 * @Description 命令接收者接口
 * @Author lvaolin
 * @Date 2022/1/26 16:27
 **/
public interface IReceiver {
    void call(String commandContext);
}
