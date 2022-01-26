package com.dhy.designpatterns.command.demo1;

/**
 * @Title CommandSave
 * @Description
 * @Author lvaolin
 * @Date 2022/1/26 16:33
 **/
public class CommandDelete implements ICommand {
    private String commandContext;
    private IReceiver receiver;

    public CommandDelete(String commandContext,IReceiver receiver){
        this.commandContext = commandContext;
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.call(commandContext);
    }
}
