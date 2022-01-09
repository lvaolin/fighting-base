package com.dhy.designpatterns.adapter.demo2;

/**
 * @Title Client
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 16:42
 **/
public class Client {

    public static void main(String[] args) {

        ILoggerManager loggerManager = new LoggerManagerImpl("jdklog");

        ILogger logger = loggerManager.getLogger("com.dhy.client");

        logger.debug("小鸡盹盹");


    }
}
