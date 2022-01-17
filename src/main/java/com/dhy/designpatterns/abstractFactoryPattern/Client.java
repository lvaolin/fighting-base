package com.dhy.designpatterns.abstractFactoryPattern;

import com.dhy.designpatterns.abstractFactoryPattern.a.FactoryTeasetA;
import com.dhy.designpatterns.abstractFactoryPattern.b.FactoryTeasetB;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/17 下午5:15
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("我想要一套A牌茶具");
        FactoryTeaset teasetA = new FactoryTeasetA();
        Tea teaA = teasetA.getTea();
        Teacup teacupA = teasetA.getTeacup();
        Teapot teapotA = teasetA.getTeapot();
        System.out.println("生产完毕：");
        teaA.show();teacupA.show();teapotA.show();

        System.out.println("我想要一套B牌茶具");
        FactoryTeaset teasetB = new FactoryTeasetB();
        Tea teaB = teasetB.getTea();
        Teacup teacupB = teasetB.getTeacup();
        Teapot teapotB = teasetB.getTeapot();
        System.out.println("生产完毕：");
        teaB.show();teacupB.show();teapotB.show();


    }
}
