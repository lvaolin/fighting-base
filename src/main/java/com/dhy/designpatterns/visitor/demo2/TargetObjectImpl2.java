package com.dhy.designpatterns.visitor.demo2;

/**
 * @Title TargetObjectImpl2
 * @Description
 * @Author lvaolin
 * @Date 2022/2/12 19:39
 **/
public class TargetObjectImpl2 implements ITagetObject {
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String name="dhy2";
    @Override
    public String accept(IVisitor visitor) {
        //必须将自身对象传进去
        return visitor.visitor(this);
    }
}
