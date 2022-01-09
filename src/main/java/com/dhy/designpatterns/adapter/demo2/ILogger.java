package com.dhy.designpatterns.adapter.demo2;

/**
 * @Title ILogger
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 16:18
 **/
public interface ILogger {
    void debug(String msg);
    void info(String msg);
    void warn(String msg);
    void error(String msg);
}
