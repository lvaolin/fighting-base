package com.dhy.designpatterns.adapter.demo2;

import com.dhy.designpatterns.adapter.demo2.jdklog.JdkLoggerAdapter;
import com.dhy.designpatterns.adapter.demo2.jdklog.JdkLoggerManagerAdapter;
import com.dhy.designpatterns.adapter.demo2.log4j.Log4jManagerAdapter;

/**
 * @Title LoggerManager
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 16:33
 **/
public class LoggerManagerImpl implements ILoggerManager{
    private String logType;//环境变量传入
    private ILoggerManager loggerManager = null;

    public LoggerManagerImpl(String logType){
        this.logType = logType;
        if ("jdklog".equalsIgnoreCase(logType)) {
            loggerManager = new JdkLoggerManagerAdapter();
        }
        if ("log4j".equalsIgnoreCase(logType)) {
            loggerManager = new Log4jManagerAdapter();
        }
        //......
    }

    @Override
    public ILogger getLogger(String name) {
        return loggerManager.getLogger(name);
    }
}
