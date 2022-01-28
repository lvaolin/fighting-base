package com.dhy.designpatterns.StrategyPattern.demo3;

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

     public RouteStrategyContext(String routeType){

         //和demo2的区别就是把 策略是实例化放到了 上下文内部，客户端无须关注实例化过程
         if ("shortest".equalsIgnoreCase(routeType)) {
             System.out.println("最短路线：");
             RouteStrategy shortestRouteStrategy = new ShortestRouteStrategy();
             this.setRouteStrategy(shortestRouteStrategy);
         }

         if ("fastest".equalsIgnoreCase(routeType)) {
             System.out.println("最快路线：");
             RouteStrategy shortestRouteStrategy = new FastestRouteStrategy();
             this.setRouteStrategy(shortestRouteStrategy);
         }

     }


     public List<String> buildRoute(String from,String to){
         if (routeStrategy==null) {
             throw new RuntimeException("没有设置策略");
         }
         return routeStrategy.buildRoute(from,to);
     }

}
