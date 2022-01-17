package com.dhy.designpatterns.abstractFactoryPattern;

/**
 * @Project fighting-core
 * @Description 茶具工厂
 * @Author lvaolin
 * @Date 2022/1/17 下午5:05
 */
public interface FactoryTeaset {
    //茶壶
    Teapot getTeapot();
    //茶杯
    Teacup getTeacup();
    //茶叶
    Tea getTea();
}
