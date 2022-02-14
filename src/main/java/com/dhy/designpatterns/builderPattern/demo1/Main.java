package com.dhy.designpatterns.builderPattern.demo1;

/**
 * @Title Client
 * @Description  传统实现方法
 * @Author lvaolin
 * @Date 2022/1/1 23:08
 **/
public class Main {
    public static void main(String[] args) {
        //房屋构造器，我们需要构造类型为1的房屋
        HouseBuilder houseBuilder1 = new HouseBuilder1();
        //房屋专家，擅长构造房屋
        Director director = new Director(houseBuilder1);
        //房屋专家构建好房屋给需要的人使用
        House house1 = director.builder();

    }
}
