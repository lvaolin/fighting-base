package com.dhy.designpatterns.bridgePattern.demo2.extend;

import com.dhy.designpatterns.bridgePattern.demo1.cpu.CpuI3;
import com.dhy.designpatterns.bridgePattern.demo1.cpu.ICpu;
import com.dhy.designpatterns.bridgePattern.demo1.disk.Disk1T;
import com.dhy.designpatterns.bridgePattern.demo1.disk.IDisk;
import com.dhy.designpatterns.bridgePattern.demo1.memory.IMemory;
import com.dhy.designpatterns.bridgePattern.demo1.memory.Memory4G;

/**
 * @Project fighting-core
 * @Description 计算机
 * @Author lvaolin
 * @Date 2022/1/11 下午7:12
 */

public  class ComputerDell_cpu3mem4disk1 extends AbstractComputer {
    CpuI3 cpu = new CpuI3();
    Memory4G memory = new Memory4G();
    Disk1T disk = new Disk1T();
    @Override
    public String showInfo() {
        return "dell computer:"+cpu.cpu()+memory.memory()+disk.disk();
    }
}
