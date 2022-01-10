package com.dhy.designpatterns.bridgePattern.demo1.memory;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/10 下午7:41
 */
public class Memory4G implements IMemory{
    @Override
    public String memory() {
        return "4G内存";
    }
}
