package com.dhy.designpatterns.command.demo1;

/**
 * @Title Client1
 * @Description
 * @Author lvaolin
 * @Date 2022/1/26 16:41
 **/
public class Client {
    public static void main(String[] args) {
        ICommand commandSave = new CommandSave("user1",new ReceiveSave());
        Invoker invoker1 = new Invoker(commandSave);
        invoker1.invoke();

        ICommand commandDelete = new CommandDelete("user1", new ReceiveDelete());
        Invoker invoker2 = new Invoker(commandDelete);
        invoker2.invoke();
    }
}
