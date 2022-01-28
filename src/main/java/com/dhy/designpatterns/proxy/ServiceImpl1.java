package com.dhy.designpatterns.proxy;

/**
 * @Title ServiceImpl1
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 18:56
 **/
public class ServiceImpl1 implements ServiceIF {
    @Override
    public String method1() {
        return "ok";
    }
}
