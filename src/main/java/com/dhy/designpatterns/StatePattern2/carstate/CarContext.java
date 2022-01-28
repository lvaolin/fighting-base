package com.dhy.designpatterns.StatePattern2.carstate;

/**
 * @Title CarContext
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 11:13
 **/
public class CarContext {

    public final static AbstractCarState stateClose = new CarStateClose();
    public final static AbstractCarState stateOpen = new CarStateOpen();
    public final static AbstractCarState stateRunning = new CarStateRunning();
    public final static AbstractCarState stateStop = new CarStateStop();

    //当前状态
    private AbstractCarState currentState;

    {
        //默认状态：关门停车状态
        currentState = stateClose;
        this.currentState.setCarContext(this);
    }

    public AbstractCarState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(AbstractCarState currentState) {
        this.currentState = currentState;
        this.currentState.setCarContext(this);
    }

    public void open() {
        currentState.open();
    }

    public void close() {
        currentState.close();
    }

    public void running() {
        currentState.running();
    }

    public void stop() {
        currentState.stop();
    }


}
