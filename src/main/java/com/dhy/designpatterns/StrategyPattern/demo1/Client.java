package com.dhy.designpatterns.StrategyPattern.demo1;

import java.util.List;

/**
 * @Title Client
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 11:38
 **/
public class Client {

    public static void main(String[] args) {

        String routeType = "fastest";
        RouteStrategyContext routeStrategyContext = new RouteStrategyContext(routeType);
        List<String> routes = routeStrategyContext.buildRoute("a", "e");
        routes.stream().forEach((route)->System.out.println(route));
    }
}
