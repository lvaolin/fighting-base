package com.dhy.designpatterns.command.demo1;

/**
 * @Title ReceiveSave
 * @Description
 * @Author lvaolin
 * @Date 2022/1/26 16:41
 **/
public class ReceiveDelete implements IReceiver{
    @Override
    public void call(String commandContext) {
        System.out.println(commandContext+"删除成功");
    }
}
