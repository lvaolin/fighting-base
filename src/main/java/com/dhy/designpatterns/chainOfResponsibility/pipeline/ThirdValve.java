package com.dhy.designpatterns.chainOfResponsibility.pipeline;


/**
 * 第三个阀门，将传入的字符串中”zz”替换成”yy”
 */
public class ThirdValve implements Valve {
    protected Valve next = null;

    public Valve getNext() {
        return next;
    }

    public void setNext(Valve valve) {
        this.next = valve;
    }

    public void invoke(String handling) {
        handling = handling.replaceAll("zz", "yy");
        System.out.println("Third阀门处理完后：" + handling);
        getNext().invoke(handling);
    }
}