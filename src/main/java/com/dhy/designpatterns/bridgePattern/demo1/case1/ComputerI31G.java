package com.dhy.designpatterns.bridgePattern.demo1.case1;

import com.dhy.designpatterns.bridgePattern.demo1.memory.IMemory;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/10 下午7:17
 */
public class ComputerI31G extends ComputerI3 implements IMemory {


    @Override
    public String memory() {
        return "1G内存";
    }
}
