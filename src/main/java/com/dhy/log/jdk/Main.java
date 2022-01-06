package com.dhy.log.jdk;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/6 上午10:19
 */
public class Main {
    public static void main(String[] args) throws IOException {
        LogManager logManager = LogManager.getLogManager();
       // logManager.readConfiguration();

//        try {
//            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("logging.properties");
//            if (in != null) {
//                LogManager.getLogManager().readConfiguration(in);
//            } else {
//                System.err.println("No such logging.properties in classpath for jdk logging config!");
//            }
//        } catch (Throwable t) {
//            System.err.println("Failed to load logging.properties in classpath for jdk logging config, cause: " + t.getMessage());
//        }


        Logger logger = Logger.getLogger(Main.class.getName());
        Logger.getGlobal().setLevel(Level.INFO);
        logger.info("info:jdk logging util..");
        //logger.setLevel(Level.SEVERE);
        Logger.getGlobal().setLevel(Level.SEVERE);
        logger.info("info:jdk logging util..");
    }
}
