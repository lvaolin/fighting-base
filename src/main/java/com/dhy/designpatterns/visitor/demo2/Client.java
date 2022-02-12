package com.dhy.designpatterns.visitor.demo2;

/**
 * @Title Client
 * @Description
 * @Author lvaolin
 * @Date 2022/2/12 19:45
 **/
public class Client {
    public static void main(String[] args) {
        ITagetObject tagetObject = new TargetObjectImpl1();
        System.out.println(tagetObject.accept(new VisitorImpl()));

        tagetObject = new TargetObjectImpl2();
        System.out.println(tagetObject.accept(new VisitorImpl()));

        tagetObject = new TargetObjectImpl3();
        System.out.println(tagetObject.accept(new VisitorImpl()));

    }
}
