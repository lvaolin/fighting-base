package com.dhy.designpatterns.command.demo2;

import java.util.Iterator;
import java.util.Stack;

/**
 * 重放指令
 */
public class ReplayCommand implements Command {

    //存放历史命令
    Stack commands=new Stack();

    @Override
    public void execute() {
        Iterator it = commands.iterator();
        while(it.hasNext()){
            Command command=(Command)it.next();
            command.execute();
        }
    }
//保存历史命令
    public void append(Command command){
        if(command!=this){
            commands.add(command);
        }
    }
//清除历史
    public void clear(){
        commands.clear();
    }

    //撤销
    public void undo(){
        if(!commands.isEmpty()){
            commands.pop();
        }
    }

}