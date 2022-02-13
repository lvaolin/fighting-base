package com.dhy.designpatterns.builderPattern.demo1;

/**
 * @Title Director
 * @Description  房屋主管（可以屏蔽客户端对构建细节的了解）
 * @Author lvaolin
 * @Date 2022/1/1 22:58
 **/
public class Director {
    HouseBuilder houseBuilder;

    public Director(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }


    House builder(){
        houseBuilder.builderDoors();
        houseBuilder.builderGarage();
        houseBuilder.builderGarden();
        houseBuilder.builderRoof();
        houseBuilder.builderSwimmingPool();
        houseBuilder.builderWindows();
        houseBuilder.builderWalls();
        return houseBuilder.getResult();
    }

}
