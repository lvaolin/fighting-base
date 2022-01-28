package com.dhy.designpatterns.StatePattern2.carstate;

public class CarStateOpen extends AbstractCarState {
    @Override
    public void open() {
        System.out.println("open状态下禁止open");
    }

    @Override
    public void close() {
        System.out.println("关门，切换到关门状态");
        //切换状态
        super.getCarContext().setCurrentState(CarContext.stateClose);
    }

    @Override
    public void running() {
        System.out.println("open状态下禁止running");
    }

    @Override
    public void stop() {
        System.out.println("open状态下禁止stop");
    }
}
