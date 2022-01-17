package com.dhy.designpatterns.flyweight;

import lombok.Data;

/**
 * @Project fighting-core
 * @Description 享元类，需要复用的部分
 * @Author lvaolin
 * @Date 2022/1/17 下午7:01
 */
@Data
public class BulletBase {
    public BulletBase(String size,String weight,String type,String color){
        this.size = size;
        this.weight = weight;
        this.type = type;
        this.color = color;
    }
    //内存状态
    private String size;
    private String weight;
    private String type;
    private String color;
}
