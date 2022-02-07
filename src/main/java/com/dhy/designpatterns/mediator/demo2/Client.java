package com.dhy.designpatterns.mediator.demo2;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/13 下午6:57
 */
public class Client {
    public static void main(String[] args) {
        IControlTower ct = new ControlTowerImpl();

        IAirplane airplane110 = new Airplane110(ct);
        IAirplane airplane111 = new Airplane111(ct);
        IAirplane airplane112 = new Airplane112(ct);
        ct.add(airplane110);
        ct.add(airplane111);
        ct.add(airplane112);

        System.out.println(airplane110.call("起飞"));
        System.out.println(airplane111.call("起飞"));
        System.out.println(airplane112.call("起飞"));

    }
}
