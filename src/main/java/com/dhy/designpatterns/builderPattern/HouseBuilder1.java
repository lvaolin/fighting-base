package com.dhy.designpatterns.builderPattern;

/**
 * @Title HouseBuilder
 * @Description 房屋构建器
 * @Author lvaolin
 * @Date 2022/1/1 22:43
 **/
public class HouseBuilder1 implements HouseBuilder {

    private  House house = new House();

    @Override
    public void builderWalls() {
        System.out.println("walls1");
    }

    @Override
    public void builderDoors() {
        System.out.println("builderDoors1");
    }

    @Override
    public void builderWindows() {
        System.out.println("builderWindows1");
    }

    @Override
    public void builderRoof() {
        System.out.println("builderRoof1");
    }

    @Override
    public void builderGarage() {
        System.out.println("builderGarage1");
    }

    @Override
    public void builderSwimmingPool() {
        System.out.println("builderSwimmingPool1");
    }

    @Override
    public void builderGarden() {
        System.out.println("builder garden1");
    }

    @Override
    public House getResult() {
        return house;
    }

    @Override
    public void reset() {
        house = new House();
    }
}
