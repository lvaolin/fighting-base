package com.dhy.designpatterns.adapter.demo2.log4j;

import com.dhy.designpatterns.adapter.demo2.ILogger;

/**
 * @Title Log4jAdapter
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 16:20
 **/
public class Log4jAdapter implements ILogger {
    private Log4jLogger log4jLogger = new Log4jLogger();
    @Override
    public void debug(String msg) {
        //参数转换
        log4jLogger.debug(msg);
    }
    @Override
    public void info(String msg) {
        //参数转换
        log4jLogger.info(msg);
    }
    @Override
    public void warn(String msg) {
        //参数转换
         log4jLogger.warn(msg);
    }
    @Override
    public void error(String msg) {
        //参数转换
        log4jLogger.error(msg);
    }
    public Log4jLogger getLog4jLogger() {
        return log4jLogger;
    }

    public void setLog4jLogger(Log4jLogger log4jLogger) {
        this.log4jLogger = log4jLogger;
    }

    /**
     * @Title JdkLogger
     * @Description  模拟已存在的jdk Logger
     * @Author lvaolin
     * @Date 2022/1/9 16:23
     **/
    static public class Log4jLogger {

        public void debug(String msg) {
            System.out.println(msg);
        }

        public void info(String msg) {
            System.out.println(msg);
        }

        public void warn(String msg) {
            System.out.println(msg);
        }

        public void error(String msg) {
            System.out.println(msg);
        }
    }

}
