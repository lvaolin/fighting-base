package com.dhy.designpatterns.adapter.demo2;

/**
 * @Title ILoggerManager
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 16:18
 **/
public interface ILoggerManager {

    ILogger getLogger(String name);
}
