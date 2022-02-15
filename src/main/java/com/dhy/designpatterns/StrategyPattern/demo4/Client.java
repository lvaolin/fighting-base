package com.dhy.designpatterns.StrategyPattern.demo4;

import java.util.List;

/**
 * @Title Client1
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 11:38
 **/
public class Client {

    public static void main(String[] args) {

        String routeType = "fastest";
        RouteStrategyContext routeStrategyContext = new RouteStrategyContext();
        List<String> routes = routeStrategyContext.buildRoute(routeType,"a", "e");
        routes.stream().forEach((route)->System.out.println(route));
    }
}
