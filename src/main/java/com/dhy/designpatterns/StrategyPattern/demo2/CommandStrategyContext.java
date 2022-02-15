package com.dhy.designpatterns.StrategyPattern.demo2;

import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CommandStrategyContext {
    //策略集合
    private static List<ICommandStrategy> list=new CopyOnWriteArrayList<>();

    static {
        //触发所有策略的自动注册
        try {
            Class.forName("com.dhy.designpatterns.StrategyPattern.demo2.CommandStrategyImpl1");
            Class.forName("com.dhy.designpatterns.StrategyPattern.demo2.CommandStrategyImpl2");
            Class.forName("com.dhy.designpatterns.StrategyPattern.demo2.CommandStrategyImpl3");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 策略注册方法
     * @param commandStrategy
     */
    public static void reg(ICommandStrategy commandStrategy){
        list.add(commandStrategy);
    }

    @SneakyThrows
    public static ICommandStrategy getCommandImpl(String flag){

        for (ICommandStrategy commandStrategy : list) {
            if (commandStrategy.isCan(flag)) {
                return commandStrategy;
            }
        }
        return null;
    }
}
