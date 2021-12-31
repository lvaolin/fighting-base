package com.dhy.designpatterns.chainOfResponsibility.pipeline;

/**
 * 阀门接口
 */
public interface Valve {
    Valve getNext();

    void setNext(Valve valve);

    void invoke(String handling);
}