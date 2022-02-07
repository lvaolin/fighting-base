package com.dhy.designpatterns.mediator.demo2;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/13 下午6:30
 */
public interface IControlTower {
    void add(IAirplane airplane);

    void remove(IAirplane airplane);

    String call(IAirplane airplane, String event);
}
