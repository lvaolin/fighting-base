package com.dhy.log.log4j;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/6 上午10:16
 */
public class Main {

    //通过反射捕获包名，从而匹配 字符串
    static Logger logger = LogManager.getLogger(Main.class);
    //只要字符串的前缀是 com.dhy.log.log4j  都可以捕获到
    //static Logger logger = LogManager.getLogger("com.dhy.log.log4j");
    //static Logger logger = LogManager.getLogger("com.dhy.log.log4j.Main.class");
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            logger.info("..........log..............");
        }

    }
}
