package com.dhy.designpatterns.command.demo3;

import com.dhy.designpatterns.command.demo2.Command;

/**
 * @Title Client
 * @Description
 * @Author lvaolin
 * @Date 2022/2/6 21:38
 **/
public class Client {
    public static void main(String[] args) {

        String content = "1234567890";
        InsertCommand insertCommand1 = new InsertCommand(content, "a");
        content = insertCommand1.doit();


        System.out.println(content);
        InsertCommand insertCommand2 = new InsertCommand(content, "b");
        content = insertCommand2.doit();
        System.out.println(content);
        InsertCommand insertCommand3= new InsertCommand(content, "c");
        content = insertCommand3.doit();
        System.out.println(content);


//        content = insertCommand3.undo();
//        System.out.println(content);
//        content = insertCommand2.undo();
//        System.out.println(content);
//        content = insertCommand1.undo();
//        System.out.println(content);

        ICommand command = null;
        while ((command = CommandHistory.pop()) != null) {
            content = command.undo();
            System.out.println(content);
        }

    }
}
