package com.dhy.designpatterns.adapter.demo2;

import com.dhy.designpatterns.adapter.demo2.jdklog.JdkLoggerAdapter;
import com.dhy.designpatterns.adapter.demo2.jdklog.JdkLoggerManagerAdapter;

/**
 * @Title LoggerManager
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 16:33
 **/
public class LoggerManagerImpl implements ILoggerManager{
    private String logType;//环境变量传入
    private JdkLoggerManagerAdapter jdkLoggerManagerAdapter = null;

    public LoggerManagerImpl(String logType){
        this.logType = logType;
        if ("jdklog".equalsIgnoreCase(logType)) {
            jdkLoggerManagerAdapter = new JdkLoggerManagerAdapter();
        }
        if ("log4j".equalsIgnoreCase(logType)) {
            jdkLoggerManagerAdapter = new JdkLoggerManagerAdapter();
        }
        //......
    }

    @Override
    public ILogger getLogger(String name) {
        return jdkLoggerManagerAdapter.getLogger(name);
    }
}
