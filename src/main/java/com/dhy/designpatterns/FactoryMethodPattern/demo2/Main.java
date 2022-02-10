package com.dhy.designpatterns.FactoryMethodPattern.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project fighting-core
 * @Description 这个是在 图解设计模式 书上看到的例子
 * 作者强调了  factory method 要和  template method 一起使用
 * 和我之前的了解还是有点区别
 *
 * @Author lvaolin
 * @Date 2022/2/9 上午11:21
 */
public class Main {
    public static void main(String[] args) {
        Factory idCardFactory = new IdCardFactory();
        Product product1 = idCardFactory.createProduct("1");
        Product product2 = idCardFactory.createProduct("2");
        Product product3 = idCardFactory.createProduct("3");

        product1.use();
        product2.use();
        product3.use();
    }
}

abstract class Product{
    abstract void use();
}

class IdCard extends Product{

    private String owner;
    public IdCard( String owner){
        this.owner = owner;
    }
    @Override
    void use() {
        System.out.println("使用"+owner+"的身份证。。。");
    }
    public String getOwner() {
        return owner;
    }

}


abstract class Factory{
    //这是一个生成产品的模板方法
    final Product create(String owner){
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }
    //生产产品
    abstract Product createProduct(String owner);
    //注册产品
    abstract void registerProduct(Product product);
}

class IdCardFactory extends Factory{


    private List owners = new ArrayList();

    @Override
    Product createProduct(String owner) {
        return new IdCard(owner);
    }

    @Override
    void registerProduct(Product product) {
        //产品注册？？？
        owners.add(((IdCard)product).getOwner());
    }

    public List getOwners() {
        return owners;
    }
}

