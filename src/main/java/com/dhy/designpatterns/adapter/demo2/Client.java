package com.dhy.designpatterns.adapter.demo2;

import com.dhy.designpatterns.adapter.demo2.log4j.Log4jAdapter;

/**
 * @Title Client1
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 16:42
 **/
public class Client {

    public static void main(String[] args) {

        ILoggerManager loggerManager = new LoggerManagerImpl("log4j");

        ILogger logger = loggerManager.getLogger("com.dhy.client");

        logger.debug("小鸡盹盹");


        ILogger log4jAdapter = new Log4jAdapter();
        log4jAdapter.info("冰墩墩");

    }
}
