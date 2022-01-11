package com.dhy.designpatterns.bridgePattern.demo2.extend;


/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/11 下午7:23
 */
public class Client {
    public static void main(String[] args) {
        AbstractComputer dell3 = new ComputerDell_cpu3mem4disk1();
        System.out.println(dell3.showInfo());
        AbstractComputer huawei3 = new ComputerHuawei_cpu3mem4disk1();
        System.out.println(huawei3.showInfo());
        AbstractComputer dell5 = new ComputerDell_cpu5mem4disk1();
        System.out.println(dell5.showInfo());
        AbstractComputer huawei5 = new ComputerHuawei_cpu5mem4disk1();
        System.out.println(huawei5.showInfo());
    }
}
