package com.dhy.designpatterns.bridgePattern.demo1.case1;

import com.dhy.designpatterns.bridgePattern.demo1.cpu.ICpu;

/**
 * @Project fighting-core
 * @Description I3 cpu
 * @Author lvaolin
 * @Date 2022/1/10 下午7:06
 */
public class ComputerI3 implements ICpu {
    @Override
    public String cpu() {
        return "i3CPU";
    }

}
