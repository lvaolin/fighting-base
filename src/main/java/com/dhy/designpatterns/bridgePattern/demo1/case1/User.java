package com.dhy.designpatterns.bridgePattern.demo1.case1;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/10 下午7:12
 */
public class User {
    public static void main(String[] args) {
        ComputerI31G1T c15 = new ComputerI31G1T();
        System.out.println(c15.cpu() + c15.memory() + c15.disk() );

        ComputerI51G1T c13 = new ComputerI51G1T();
        System.out.println(c13.cpu() + c13.memory() + c13.disk() );
    }
}
