package com.dhy.designpatterns.decorator.demo1;

/**
 * 利用装饰器模式
 * 获取 鸡蛋香肠手抓饼的价格
 * 获取 香肠鸡蛋手抓饼的价格
 */
public class Test {

    public static void main(String[] args) {
        Bread shreddedBread= new ShreddedBread(null);

        Bread sausageShreddedBread = new SausageBread(shreddedBread);

        Bread eggsausageShrededBread = new EggBread(sausageShreddedBread);

        System.out.println("你要的鸡蛋香肠手抓饼："+eggsausageShrededBread.getDesc()+eggsausageShrededBread.getPrice());

        Bread eggShrededBread = new EggBread(shreddedBread);

        System.out.println("我要的鸡蛋手抓饼："+eggShrededBread.getDesc()+eggShrededBread.getPrice());

        Bread eggBread = new EggBread(null);
        Bread sausageEggBread = new SausageBread(eggBread);

        System.out.println("他要的香肠鸡蛋饼："+sausageEggBread.getDesc()+sausageEggBread.getPrice());
    }

}
