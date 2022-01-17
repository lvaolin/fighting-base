package com.dhy.designpatterns.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Project fighting-core
 * @Description 游戏场景
 * @Author lvaolin
 * @Date 2022/1/17 下午7:15
 */
public class Game {

    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        List<MovingBullet> list = new ArrayList<>();
        //某人发射大量子弹
        for (int i = 0; i < 10; i++) {
            MovingBullet movingBullet = new MovingBullet();
            movingBullet.setBulletBase(flyweightFactory.getBulletBase("red"));
            movingBullet.setX(ThreadLocalRandom.current().nextInt(100));
            movingBullet.setY(ThreadLocalRandom.current().nextInt(100));
            movingBullet.setZ(ThreadLocalRandom.current().nextInt(100));
            list.add(movingBullet);
            System.out.println(movingBullet.toString());
        }


    }
}
