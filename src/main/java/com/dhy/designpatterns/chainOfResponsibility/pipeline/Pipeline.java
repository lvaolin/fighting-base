package com.dhy.designpatterns.chainOfResponsibility.pipeline;

/**
 * 管道接口
 */
public interface Pipeline {
    Valve getFirst();

    Valve getBasic();

    void setBasic(Valve valve);

    void addValve(Valve valve);
}