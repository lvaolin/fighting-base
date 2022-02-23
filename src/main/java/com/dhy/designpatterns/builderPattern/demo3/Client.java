package com.dhy.designpatterns.builderPattern.demo3;

/**
 * @Title Client
 * @Description  这个模式至少需要两个类
 * 一个是  构建的目标类  Target
 * 一个是  构建器  TargetBuilder
 *
 * 构建过程一般使用fluent风格的代码，来提高用户体验
 *
 * 构建器的任务是从客户哪里搜集各种参数，最后把这些参数一次性的扔个目标对象来实例化一个对象
 *
 * @Author lvaolin
 * @Date 2022/2/23 9:15
 **/
public class Client {

    public static void main(String[] args) {
        TargetBuilder targetBuilder = new TargetBuilder();
        Target build = targetBuilder.buildId("id1").buildName("name1").build();

        StringBuilder sb = new StringBuilder();
        String string = sb.append("a").append("b").append("c").toString();

    }
}
