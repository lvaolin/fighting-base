package com.dhy.designpatterns.StrategyPattern.demo3;

import java.util.List;

/**
 * @Title RouteStrategy
 * @Description 线路规划策略接口
 * @Author lvaolin
 * @Date 2022/1/9 11:27
 **/
public interface RouteStrategy {
       List<String> buildRoute(String from, String to);
}
