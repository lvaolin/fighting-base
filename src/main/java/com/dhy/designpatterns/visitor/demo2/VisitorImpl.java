package com.dhy.designpatterns.visitor.demo2;

/**
 * @Title VisitorImpl1
 * @Description
 * @Author lvaolin
 * @Date 2022/2/12 19:43
 **/
public class VisitorImpl implements IVisitor {
    @Override
    public String visitor(TargetObjectImpl1 t) {
        return t.getName();
    }

    @Override
    public String visitor(TargetObjectImpl2 t) {
        return t.getName();
    }

    @Override
    public String visitor(TargetObjectImpl3 t) {
        return t.getName();
    }
}
