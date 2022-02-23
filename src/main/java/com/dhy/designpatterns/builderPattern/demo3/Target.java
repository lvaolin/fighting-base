package com.dhy.designpatterns.builderPattern.demo3;

/**
 * @Title Target
 * @Description
 * @Author lvaolin
 * @Date 2022/2/23 9:11
 **/
public class Target {
    private String id;
    private String name;
    public Target(TargetBuilder tb){
        this.id = tb.getId();
        this.name = tb.getName();
    }
}

 class TargetBuilder {
    private String id;
    private String name;

    public TargetBuilder buildId(String id){
        this.id = id;
        return this;
    }

    public TargetBuilder buildName(String name){
        this.name = name;
        return this;
    }

    public Target build(){
        return  new Target(this);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
