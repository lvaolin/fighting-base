package com.dhy.designpatterns.builderPattern.demo2;


/**
 * @Title Client1
 * @Description  用于复杂对象的构建，定制化构建
 * @Author lvaolin
 * @Date 2022/2/13 20:44
 **/
public class Client {
    public static void main(String[] args) {

        HouseBuilder houseBuilder = new HouseBuilder();
        House house = houseBuilder
                .setDoors(new House.Door())
                .setWindows(new House.Window())
                .setWalls(new House.Wall())
                .setSwimmingPool(new House.SwimmingPool())
                .setRoof(new House.Roof())
                .setGarden(new House.Garden())
                .setGarage(new House.Garage())
                .build();

    }
}
