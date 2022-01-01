package com.dhy.designpatterns.builderPattern;

/**
 * @Title Main
 * @Description
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

        //房屋构造器，我们需要构造类型为2的房屋
        HouseBuilder houseBuilder2 = new HouseBuilder2();
        //更换下构造器2
        director.changeBuilder(houseBuilder2);

        House house2 = director.builder();
    }
}
