package com.dhy.designpatterns.StrategyPattern.demo2;

import java.util.List;

/**
 * @Title Client
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 11:38
 **/
public class Client {

    public static void main(String[] args) {

        String routeType = "shortest";
        RouteStrategyContext routeStrategyContext = new RouteStrategyContext();
        if ("shortest".equalsIgnoreCase(routeType)) {
            System.out.println("最短路线：");
            RouteStrategy shortestRouteStrategy = new ShortestRouteStrategy();
            routeStrategyContext.setRouteStrategy(shortestRouteStrategy);
            List<String> routes = routeStrategyContext.buildRoute("a", "e");
            routes.stream().forEach((route)->System.out.println(route));
        }

        routeType = "fastest";
        if ("fastest".equalsIgnoreCase(routeType)) {
            System.out.println("最快路线：");
            RouteStrategy shortestRouteStrategy = new FastestRouteStrategy();
            routeStrategyContext.setRouteStrategy(shortestRouteStrategy);
            List<String> routes = routeStrategyContext.buildRoute("a", "e");
            routes.stream().forEach((route)->System.out.println(route));
        }




    }
}
