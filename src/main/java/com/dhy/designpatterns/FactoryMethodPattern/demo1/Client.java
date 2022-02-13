package com.dhy.designpatterns.FactoryMethodPattern.demo1;


import com.dhy.designpatterns.FactoryMethodPattern.demo1.FactoryHuawei;
import com.dhy.designpatterns.FactoryMethodPattern.demo1.FactoryXiaomi;
import com.dhy.designpatterns.FactoryMethodPattern.demo1.IFactory;
import com.dhy.designpatterns.FactoryMethodPattern.demo1.IProduct;

public class Client {

    public static void main(String[] args) {
        IFactory factory;
        IProduct product;
        
        //华为工厂 生产华为播放器
        factory = new FactoryHuawei();
        product = factory.getProduct();
        product.sing();

        //小米工厂 生产小米播放器
        factory = new FactoryXiaomi();
        product = factory.getProduct();
        product.sing();
    }
}
