package com.dhy.designpatterns.bridgePattern.demo1.color;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/10 下午7:29
 */
public class ColorRed implements IColor {

    @Override
    public String color() {
        return "红色";
    }
}
