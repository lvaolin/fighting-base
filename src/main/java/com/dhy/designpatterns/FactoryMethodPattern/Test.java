package com.dhy.designpatterns.FactoryMethodPattern;


public class Test {

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
