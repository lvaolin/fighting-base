package com.dhy.designpatterns.StrategyPattern.demo2;

import lombok.Data;

import java.util.List;

/**
 * @Title RouteStrategyContext
 * @Description  路由策略上下文
 * @Author lvaolin
 * @Date 2022/1/9 11:35
 **/

@Data
public class RouteStrategyContext {

     private RouteStrategy routeStrategy;

     public RouteStrategyContext(){

     }
     public RouteStrategyContext(RouteStrategy routeStrategy){
         this.routeStrategy = routeStrategy;
     }

     public List<String> buildRoute(String from,String to){
         if (routeStrategy==null) {
             throw new RuntimeException("没有设置策略");
         }
         return routeStrategy.buildRoute(from,to);
     }

}
