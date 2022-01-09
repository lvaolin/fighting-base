package com.dhy.designpatterns.StrategyPattern.demo3;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title ShortestRouteStrategy
 * @Description 里程最短路线
 * @Author lvaolin
 * @Date 2022/1/9 11:31
 **/
public class ShortestRouteStrategy implements RouteStrategy {

    @Override
    public List<String> buildRoute(String from, String to) {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("a");
        strings.add("b");
        strings.add("e");
        return strings;
    }
}
