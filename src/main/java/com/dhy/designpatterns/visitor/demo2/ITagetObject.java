package com.dhy.designpatterns.visitor.demo2;

/**
 * @Title ITagetObject
 * @Description  一个对象，必须待 accept方法 来接收 IVisitor对象
 * @Author lvaolin
 * @Date 2022/2/12 19:38
 **/
public interface ITagetObject {
    String accept(IVisitor visitor);
}
