package com.dhy.designpatterns.builderPattern.demo1;

/**
 * @Title HouseBuilder
 * @Description 房屋构建器
 * @Author lvaolin
 * @Date 2022/1/1 22:43
 **/
public interface HouseBuilder {


    //构建墙壁
    void builderWalls();

    //构建房门
    void builderDoors();

    //构建窗户
    void builderWindows();

    //构建屋顶
    void builderRoof();

    //构建车库
    void builderGarage();

    //构建泳池
    void builderSwimmingPool();

    //构建花园
    void builderGarden();

    House getResult();

}
