package com.dhy.designpatterns.chainOfResponsibility.pipeline;

/**
 * 基础阀门，处理逻辑仅仅是简单的将传入的字符串中”aa”替换成”bb”
 * 最后一个调用，相当于单链表的 "尾结点"
 */
public class BasicValve implements Valve {
    protected Valve next = null;

    public Valve getNext() {
        return next;
    }

    public void setNext(Valve valve) {
        this.next = valve;
    }

    public void invoke(String handling) {
        handling = handling.replaceAll("aa", "bb");
        System.out.println("基础阀门处理完后：" + handling);
    }
}