package com.dhy.designpatterns.StrategyPattern.demo4;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title RouteStrategyContext
 * @Description  路由策略上下文
 * @Author lvaolin
 * @Date 2022/1/9 11:35
 **/

@Data
public class RouteStrategyContext {

     private List<RouteStrategy> routeStrategyList = new ArrayList<>();

    {
        //将所有策略注册进来(更进一步的方法是SPI，通过加载配置文件来注册所有的策略，这就完全符合开闭原则了)
        routeStrategyList.add(new ShortestRouteStrategy());
        routeStrategyList.add(new FastestRouteStrategy());
    }

     public List<String> buildRoute(String routeType,String from,String to){
         RouteStrategy routeStrategy = routeStrategyList.stream().filter(route -> route.isSupport(routeType)).findAny().get();
         return routeStrategy.buildRoute(from, to);
     }

}
