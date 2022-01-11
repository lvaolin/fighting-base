package com.dhy.designpatterns.bridgePattern.demo2;

import com.dhy.designpatterns.bridgePattern.demo1.cpu.ICpu;
import com.dhy.designpatterns.bridgePattern.demo1.disk.IDisk;
import com.dhy.designpatterns.bridgePattern.demo1.memory.IMemory;

/**
 * @Project fighting-core
 * @Description 计算机
 * @Author lvaolin
 * @Date 2022/1/11 下午7:12
 */

public  class ComputerHuawei extends AbstractComputer{

    public ComputerHuawei(ICpu cpu, IMemory memory, IDisk disk){
        super(cpu,memory,disk);
    }

    @Override
    public String showInfo() {
        return "huawei computer:"+getCpu().cpu()+getMemory().memory()+getDisk().disk();
    }
}
