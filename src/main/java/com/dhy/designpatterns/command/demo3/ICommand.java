package com.dhy.designpatterns.command.demo3;

/**
 * @Title ICommand
 * @Description
 * @Author lvaolin
 * @Date 2022/2/6 21:27
 **/
public interface ICommand {
    /**
     * 正向操作
     */
    String doit();

    /**
     * 反向操作
     */
    String undo();
}
