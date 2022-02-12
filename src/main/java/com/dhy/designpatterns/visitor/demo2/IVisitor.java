package com.dhy.designpatterns.visitor.demo2;

/**
 * @Title IVisitor
 * @Description 访问者需要实现的接口，实际上和具体的对象类耦合了
 *
 * @Author lvaolin
 * @Date 2022/2/12 19:40
 **/
public interface IVisitor {
    String visitor(TargetObjectImpl1 t);
    String visitor(TargetObjectImpl2 t);
    String visitor(TargetObjectImpl3 t);
}
