package com.dhy.designpatterns.bridgePattern.demo2;

import com.dhy.designpatterns.bridgePattern.demo1.cpu.ICpu;
import com.dhy.designpatterns.bridgePattern.demo1.disk.IDisk;
import com.dhy.designpatterns.bridgePattern.demo1.memory.IMemory;
import lombok.Data;

/**
 * @Project fighting-core
 * @Description 计算机
 * @Author lvaolin
 * @Date 2022/1/11 下午7:12
 */

@Data
public abstract class AbstractComputer {
    private ICpu cpu;
    private IMemory memory;
    private IDisk disk;
    public AbstractComputer(ICpu cpu,IMemory memory,IDisk disk){
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }
    public abstract String showInfo();
}
