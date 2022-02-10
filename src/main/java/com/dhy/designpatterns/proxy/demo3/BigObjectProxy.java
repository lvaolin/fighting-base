package com.dhy.designpatterns.proxy.demo3;

import java.util.concurrent.TimeUnit;

/**
 * @Project fighting-core
 * @Description 对象代理
 * @Author lvaolin
 * @Date 2022/2/10 下午3:53
 */
public class BigObjectProxy implements BigObjectInterface{
    private BigObjectInterface bigObjectInterface;
    @Override
    public String m1(String name) {
        //延迟对象初始化
        if (bigObjectInterface==null) {
            bigObjectInterface = new BigObjectService();
            System.out.println("目标对象实例化完成");
        }
        System.out.println("实际调用");
        return bigObjectInterface.m1(name);
    }
}
