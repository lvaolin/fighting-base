package com.dhy.designpatterns.builderPattern;

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


    class SwimmingPool {
    }

    class Garden {
    }

    class Wall {
    }

    class Door {
    }

    class Window {
    }

    class Roof {
    }

    class Garage {
    }
}
