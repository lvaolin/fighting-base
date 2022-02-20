package com.dhy.designpatterns.StrategyPattern.demo0;

import java.util.List;

/**
 * @Title Client1
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 11:38
 **/
public class Client {
    public static void main(String[] args) {
        //地图导航策略
        //策略上下文
        RouteStrategyContext routeStrategyContext = new RouteStrategyContext();

        //切换到：距离最短策略
        routeStrategyContext.setRouteStrategy(new ShortestRouteStrategy());
        List<String> routes = routeStrategyContext.buildRoute("a", "e");
        routes.stream().forEach((route)->System.out.println(route));

        //切换到：花费时间最少策略
        routeStrategyContext.setRouteStrategy(new FastestRouteStrategy());
        routes = routeStrategyContext.buildRoute("a", "e");
        routes.stream().forEach((route)->System.out.println(route));
    }
}
