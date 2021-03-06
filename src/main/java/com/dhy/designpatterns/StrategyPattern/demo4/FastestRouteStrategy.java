package com.dhy.designpatterns.StrategyPattern.demo4;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title FastestRouteStrategy
 * @Description 耗时最短路线
 * @Author lvaolin
 * @Date 2022/1/9 11:31
 **/
public class FastestRouteStrategy implements RouteStrategy {

    @Override
    public boolean isSupport(String routeType) {
        return "fastest".equalsIgnoreCase(routeType);
    }

    @Override
    public List<String> buildRoute(String from, String to) {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("a");
        strings.add("d");
        strings.add("f");
        strings.add("e");
        return strings;
    }
}
