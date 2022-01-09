package com.dhy.designpatterns.adapter.demo2.jdklog;

import com.dhy.designpatterns.adapter.demo2.ILogger;

/**
 * @Title JdkLogger
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 16:20
 **/
public class JdkLoggerAdapter implements ILogger {



    private JdkLogger jdkLogger;

    @Override
    public void debug(String msg) {
        //参数转换
        jdkLogger.debug(msg);
    }

    @Override
    public void info(String msg) {
        //参数转换
        jdkLogger.info(msg);
    }

    @Override
    public void warn(String msg) {
        //参数转换
         jdkLogger.warn(msg);
    }

    @Override
    public void error(String msg) {
        //参数转换
        jdkLogger.error(msg);
    }
    public JdkLogger getJdkLogger() {
        return jdkLogger;
    }

    public void setJdkLogger(JdkLogger jdkLogger) {
        this.jdkLogger = jdkLogger;
    }

    /**
     * @Title JdkLogger
     * @Description  模拟已存在的jdk Logger
     * @Author lvaolin
     * @Date 2022/1/9 16:23
     **/
    static public class JdkLogger {

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
