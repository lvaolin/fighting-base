package com.dhy.designpatterns.builderPattern.demo1;

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
