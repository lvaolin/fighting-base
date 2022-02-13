package com.dhy.designpatterns.builderPattern.demo2;

import lombok.Data;

/**
 * @Title House
 * @Description
 * @Author lvaolin
 * @Date 2022/1/1 22:49
 **/
@Data
public class House {
    private Wall walls;
    private Door doors;
    private Window windows;
    private Roof roof;
    private Garage garage;
    private SwimmingPool swimmingPool;
    private Garden garden;

    public House(HouseBuilder builder){
        this.walls = builder.getWalls();
        this.doors = builder.getDoors();
        this.windows = builder.getWindows();
        this.roof = builder.getRoof();
        this.garage = builder.getGarage();
        this.swimmingPool = builder.getSwimmingPool();
        this.garden = builder.getGarden();
        //如果为null可以进行默认值设置
    }
    static class SwimmingPool {
    }
    static class Garden {
    }
    static class Wall {
    }
    static class Door {
    }
    static class Window {
    }
    static class Roof {
    }
    static class Garage {
    }
}
