package com.dhy.designpatterns.bridgePattern.demo1.case2;

import com.dhy.designpatterns.bridgePattern.demo1.cpu.ICpu;
import com.dhy.designpatterns.bridgePattern.demo1.disk.IDisk;
import com.dhy.designpatterns.bridgePattern.demo1.memory.IMemory;
import lombok.Data;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/10 下午7:37
 */
@Data
public class ComputerBridge {
    private ICpu cpu;
    private IMemory memory;
    private IDisk disk;

    public ComputerBridge(ICpu cpu, IMemory memory, IDisk disk){
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public String show(){
        return cpu.cpu() + memory.memory() + disk.disk();
    }

}
