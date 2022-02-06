package com.dhy.designpatterns.command.demo3;

/**
 * @Title DeleteCommand
 * @Description
 * @Author lvaolin
 * @Date 2022/2/6 21:34
 **/
public class DeleteCommand implements ICommand {

    private String content;
    private String delete;
    public DeleteCommand(String content,String delete){
        this.content = content;
        this.delete = delete;
    }

    @Override
    public String doit() {
        CommandHistory.push(this);
return content;
    }

    @Override
    public String undo() {
        return content;
    }
}
