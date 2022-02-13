package com.dhy.designpatterns.builderPattern.demo1;

/**
 * @Title HouseBuilder
 * @Description 房屋构建器
 * @Author lvaolin
 * @Date 2022/1/1 22:43
 **/
public class HouseBuilder2 implements HouseBuilder {

    private  House house = new House();

    @Override
    public void builderWalls() {
        System.out.println("walls2");
    }

    @Override
    public void builderDoors() {
        System.out.println("builderDoors2");
    }

    @Override
    public void builderWindows() {
        System.out.println("builderWindows2");
    }

    @Override
    public void builderRoof() {
        System.out.println("builderRoof2");
    }

    @Override
    public void builderGarage() {
        System.out.println("builderGarage2");
    }

    @Override
    public void builderSwimmingPool() {
        System.out.println("builderSwimmingPool2");
    }

    @Override
    public void builderGarden() {
        System.out.println("builder garden2");
    }

    @Override
    public House getResult() {
        return house;
    }

}
