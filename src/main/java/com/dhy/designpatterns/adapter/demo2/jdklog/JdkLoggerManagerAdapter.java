package com.dhy.designpatterns.adapter.demo2.jdklog;

import com.dhy.designpatterns.adapter.demo2.ILogger;
import com.dhy.designpatterns.adapter.demo2.ILoggerManager;

/**
 * @Title JdkLoggerManager
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 16:22
 **/
public class JdkLoggerManagerAdapter implements ILoggerManager {

    private JdkLoggerFactory  jdkLoggerFactory = new JdkLoggerFactory();

    @Override
    public ILogger getLogger(String name) {
        //参数转换
        JdkLoggerAdapter.JdkLogger logger = jdkLoggerFactory.getLogger(name);
        //类型转换
        JdkLoggerAdapter jdkLoggerAdapter = new JdkLoggerAdapter();
        jdkLoggerAdapter.setJdkLogger(logger);

        return jdkLoggerAdapter;
    }


    /**
     *  模拟已经存在的jdl logfactory
     */
    private class JdkLoggerFactory {

        public JdkLoggerAdapter.JdkLogger getLogger(String name) {
            return new JdkLoggerAdapter.JdkLogger();
        }
    }
}
