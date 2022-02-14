package com.dhy.designpatterns.StatePattern2.carstate;

/**
 * @Title AbstractCarState
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 11:16
 **/
public abstract class AbstractCarState {
    public CarContext getCarContext() {
        return carContext;
    }

    public void setCarContext(CarContext carContext) {
        this.carContext = carContext;
    }
    //对上下文的引用也可以放到子类中
    private CarContext carContext;


    /**
     * 开门
     */
    abstract void open();

    /**
     * 关门
     */
    abstract void close();

    /**
     * 驱动前行
     */
    abstract void running();

    /**
     * 停车
     */
    abstract void stop();

}
