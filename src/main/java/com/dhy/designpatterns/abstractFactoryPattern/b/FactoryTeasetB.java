package com.dhy.designpatterns.abstractFactoryPattern.b;

import com.dhy.designpatterns.abstractFactoryPattern.FactoryTeaset;
import com.dhy.designpatterns.abstractFactoryPattern.Tea;
import com.dhy.designpatterns.abstractFactoryPattern.Teacup;
import com.dhy.designpatterns.abstractFactoryPattern.Teapot;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/17 下午5:09
 */
public class FactoryTeasetB implements FactoryTeaset {
    @Override
    public Teapot getTeapot() {
        return new TeapotB();
    }

    @Override
    public Teacup getTeacup() {
        return new TeacupB();
    }

    @Override
    public Tea getTea() {
        return new TeaB();
    }
}
