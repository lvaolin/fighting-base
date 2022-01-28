package com.dhy.designpatterns.StatePattern2.carstate;

public class CarStateRunning extends AbstractCarState{
    @Override
    public void open() {
        System.out.println("开车状态下禁止开门");
    }

    @Override
    public void close() {
        System.out.println("running状态下禁止close");
    }


    @Override
    public void running() {
        System.out.println("running状态下禁止running");
    }

    @Override
    public void stop() {
        System.out.println("停车，切换到停车状态");
        //切换状态
        super.getCarContext().setCurrentState(CarContext.stateStop);
    }
}
