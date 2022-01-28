package com.dhy.designpatterns.StatePattern2.carstate;

public class CarStateStop extends AbstractCarState {
    @Override
    public void open() {
        System.out.println("开门，切换到开门状态");
        //切换
        super.getCarContext().setCurrentState(CarContext.stateOpen);
    }

    @Override
    public void close() {
        System.out.println("stop状态下禁止close");
    }

    @Override
    public void running() {
        System.out.println("开车，切换到开车状态");
        //切换到running状态
        super.getCarContext().setCurrentState(CarContext.stateRunning);
    }

    @Override
    public void stop() {
        System.out.println("stop状态下禁止stop");
    }
}
