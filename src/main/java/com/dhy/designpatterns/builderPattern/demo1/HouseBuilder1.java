package com.dhy.designpatterns.builderPattern.demo1;

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
        house.setWalls(new House.Wall());
    }

    @Override
    public void builderDoors() {
        house.setDoors(new House.Door());
    }

    @Override
    public void builderWindows() {
        house.setWindows(new House.Window());
    }

    @Override
    public void builderRoof() {
        house.setRoof(new House.Roof());
    }

    @Override
    public void builderGarage() {
        house.setGarage(new House.Garage());
    }

    @Override
    public void builderSwimmingPool() {
        house.setSwimmingPool(new House.SwimmingPool());
    }

    @Override
    public void builderGarden() {
        house.setGarden(new House.Garden());
    }

    @Override
    public House getResult() {
        return house;
    }

}
