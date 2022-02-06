package com.dhy.designpatterns.command.demo3;

/**
 * @Title CopyCommand
 * @Description
 * @Author lvaolin
 * @Date 2022/2/6 21:28
 **/
public class InsertCommand implements ICommand {
    private String content;
    private String insert;
    public InsertCommand(String content,String insert){
        this.content = content;
        this.insert = insert;
    }
    @Override
    public String doit() {
        CommandHistory.push(this);
        return content+insert;
    }

    @Override
    public String undo() {
        return content;
    }
}
