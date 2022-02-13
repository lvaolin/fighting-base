package com.dhy.designpatterns.builderPattern.demo2;

import lombok.Getter;

/**
 * @Title HouseBuilder
 * @Description  房屋构造器
 * @Author lvaolin
 * @Date 2022/2/13 20:49
 **/
@Getter
public class HouseBuilder {

    private House.Wall walls;
    private House.Door doors;
    private House.Window windows;
    private House.Roof roof;
    private House.Garage garage;
    private House.SwimmingPool swimmingPool;
    private House.Garden garden;

    public HouseBuilder setWalls(House.Wall walls) {
        this.walls = walls;
        return this;
    }
    public HouseBuilder setDoors(House.Door doors) {
        this.doors = doors;
        return this;
    }
    public HouseBuilder setWindows(House.Window windows) {
        this.windows = windows;
        return this;
    }
    public HouseBuilder setRoof(House.Roof roof) {
        this.roof = roof;
        return this;
    }
    public HouseBuilder setGarage(House.Garage garage) {
        this.garage = garage;
        return this;
    }
    public HouseBuilder setSwimmingPool(House.SwimmingPool swimmingPool) {
        this.swimmingPool = swimmingPool;
        return this;
    }
    public HouseBuilder setGarden(House.Garden garden) {
        this.garden = garden;
        return this;
    }

    public House build(){
        return new House(this);
    }

}

