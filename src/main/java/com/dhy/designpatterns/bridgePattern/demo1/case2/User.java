package com.dhy.designpatterns.bridgePattern.demo1.case2;

import com.dhy.designpatterns.bridgePattern.demo1.cpu.CpuI3;
import com.dhy.designpatterns.bridgePattern.demo1.cpu.CpuI5;
import com.dhy.designpatterns.bridgePattern.demo1.disk.Disk1T;
import com.dhy.designpatterns.bridgePattern.demo1.memory.Memory4G;

/**
 * @Project fighting-core
 * @Description  桥接模式解决类爆炸问题
 * @Author lvaolin
 * @Date 2022/1/10 下午7:42
 */
public class User {
    public static void main(String[] args) {
        ComputerBridge computer = new ComputerBridge(
                new CpuI3(),
                new Memory4G(),
                new Disk1T());

        System.out.println(computer.show());

        ComputerBridge computer2 = new ComputerBridge(
                new CpuI5(),
                new Memory4G(),
                new Disk1T());

        System.out.println(computer2.show());
    }
}
