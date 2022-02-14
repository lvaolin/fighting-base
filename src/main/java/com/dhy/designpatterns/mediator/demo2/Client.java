package com.dhy.designpatterns.mediator.demo2;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/13 下午6:57
 */
public class Client {
    public static void main(String[] args) {
        //塔台
        IControlTower ct = new ControlTowerImpl();

        //110号航班
        IAirplane airplane110 = new Airplane110(ct);
        //111号航班
        IAirplane airplane111 = new Airplane111(ct);
        //112号航班
        IAirplane airplane112 = new Airplane112(ct);
        //向塔台注册飞机
        ct.add(airplane110);
        ct.add(airplane111);
        ct.add(airplane112);

        //起飞 申请跑道
        System.out.println(airplane110.call("申请起飞"));
        System.out.println(airplane111.call("申请起飞"));
        System.out.println(airplane112.call("申请起飞"));

    }
}
