package com.dhy.designpatterns.bridgePattern.demo2;

import com.dhy.designpatterns.bridgePattern.demo1.cpu.CpuI3;
import com.dhy.designpatterns.bridgePattern.demo1.cpu.CpuI5;
import com.dhy.designpatterns.bridgePattern.demo1.disk.Disk1T;
import com.dhy.designpatterns.bridgePattern.demo1.memory.Memory4G;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/11 下午7:23
 */
public class Client {
    public static void main(String[] args) {
        AbstractComputer dell3 = new ComputerDell(new CpuI3(),new Memory4G(),new Disk1T());
        System.out.println(dell3.showInfo());
        AbstractComputer huawei3 = new ComputerHuawei(new CpuI3(),new Memory4G(),new Disk1T());
        System.out.println(huawei3.showInfo());
        AbstractComputer dell5 = new ComputerDell(new CpuI5(),new Memory4G(),new Disk1T());
        System.out.println(dell5.showInfo());
        AbstractComputer huawei5 = new ComputerHuawei(new CpuI5(),new Memory4G(),new Disk1T());
        System.out.println(huawei5.showInfo());
    }
}
