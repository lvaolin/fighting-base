package com.dhy.designpatterns.command.demo1;

/**
 * @Title Invoker
 * @Description 调用者，法号命令的人
 * @Author lvaolin
 * @Date 2022/1/26 16:26
 **/
public class Invoker {
    //要发送的命令
    private ICommand command;

    public Invoker(ICommand command){
        this.command = command;
    }

    public void invoke(){
        command.execute();
    }

}
