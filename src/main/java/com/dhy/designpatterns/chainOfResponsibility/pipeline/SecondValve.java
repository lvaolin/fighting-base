package com.dhy.designpatterns.chainOfResponsibility.pipeline;

/**
 * 第二个阀门，将传入的字符串中”11”替换成”22”
 */
public class SecondValve implements Valve {
    protected Valve next = null;

    public Valve getNext() {
        return next;
    }

    public void setNext(Valve valve) {
        this.next = valve;
    }

    public void invoke(String handling) {
        handling = handling.replaceAll("11", "22");
        System.out.println("Second阀门处理完后：" + handling);
        getNext().invoke(handling);
    }
}