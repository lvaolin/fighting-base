package com.dhy.designpatterns.bridgePattern.demo1.cpu;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/10 下午7:35
 */
public class CpuI5 implements ICpu{
    @Override
    public String cpu() {
        return "I5";
    }
}
