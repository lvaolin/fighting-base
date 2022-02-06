package com.dhy.designpatterns.command.demo3;

import java.util.Stack;

/**
 * @Title CommandHistory
 * @Description
 * @Author lvaolin
 * @Date 2022/2/6 21:51
 **/
public class CommandHistory {
    private static Stack<ICommand> commands = new Stack<>();
    static void push(ICommand command){
        commands.push(command);
    }
    static ICommand pop(){
        return commands.pop();
    }
}
