package com.dhy.designpatterns.flyweight;

import lombok.Data;

/**
 * @Project fighting-core
 * @Description 大量存在的对象
 * @Author lvaolin
 * @Date 2022/1/17 下午7:03
 */
@Data
public class MovingBullet {
    //不变的属性称为"内在状态"，封装到另一个对象中，便于复用
    private BulletBase bulletBase;
    //下面三个属性是外在状态
    private int x;
    private int y;
    private int z;
}
