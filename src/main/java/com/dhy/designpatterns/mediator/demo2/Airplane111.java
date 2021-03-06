package com.dhy.designpatterns.mediator.demo2;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/13 下午6:25
 */
public class Airplane111 implements IAirplane{

    private IControlTower controlTower;
    public Airplane111(IControlTower controlTower){
        this.controlTower = controlTower;
    }
    @Override
    public String call(String event) {
        return controlTower.call(this,event);
    }
}
