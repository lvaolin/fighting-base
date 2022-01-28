package com.dhy.designpatterns.StatePattern2.carstate;

/**
 * @Title CarContext
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 11:13
 **/
public class CarContext {

    //所有的状态对象 列到这里  不是必须的。
    public final static AbstractCarState stateClose = new CarStateClose();
    public final static AbstractCarState stateOpen = new CarStateOpen();
    public final static AbstractCarState stateRunning = new CarStateRunning();
    public final static AbstractCarState stateStop = new CarStateStop();

    //当前状态，关键原理就在于不断变更 这个状态对象来实现 状态的变更
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
        //这一句也很重要，否则状态对象中就因为无法找到上下文从而无法变更上下文中的currentState对象
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
