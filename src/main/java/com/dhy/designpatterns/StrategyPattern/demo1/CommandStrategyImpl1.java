package com.dhy.designpatterns.StrategyPattern.demo1;

public class CommandStrategyImpl1 implements ICommandStrategy {
    static {
        //加载自动注册到策略上下文中
        CommandStrategyContext.reg(new CommandStrategyImpl1());
    }
    @Override
    public boolean isCan(String flag) {
        return  "1".equals(flag)?true:false;
    }

    @Override
    public void receive(String data) {
        System.out.println(1);
    }

    @Override
    public void response(String data) {
        System.out.println(1);
    }
}
