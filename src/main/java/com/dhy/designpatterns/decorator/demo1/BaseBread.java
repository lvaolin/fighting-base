package com.dhy.designpatterns.decorator.demo1;

/**
 * 最基础的白饼
 */
public abstract class BaseBread implements Bread {

    private Bread bread;

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

}
