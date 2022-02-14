package com.dhy.designpatterns.adapter.demo2.log4j;

import com.dhy.designpatterns.adapter.demo2.ILogger;
import com.dhy.designpatterns.adapter.demo2.ILoggerManager;

/**
 * @Title JdkLoggerManager
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 16:22
 **/
public class Log4jManagerAdapter implements ILoggerManager {

    private Log4jFactory factory = new Log4jFactory();

    @Override
    public ILogger getLogger(String name) {
        //参数转换
        Log4jAdapter.Log4jLogger logger = factory.getLogger(name);
        //类型转换
        Log4jAdapter jdkLoggerAdapter = new Log4jAdapter();
        jdkLoggerAdapter.setLog4jLogger(logger);

        return jdkLoggerAdapter;
    }


    /**
     *  模拟已经存在的jdl logfactory
     */
    private class Log4jFactory {

        public Log4jAdapter.Log4jLogger getLogger(String name) {
            return new Log4jAdapter.Log4jLogger();
        }
    }
}
