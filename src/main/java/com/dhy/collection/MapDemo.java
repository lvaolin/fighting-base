package com.dhy.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2023/4/27 上午8:26
 */
public class MapDemo {
    public static void main(String[] args) {
        Map map = new HashMap<String,String>();
        ConcurrentMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

        List<Object> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add("1");
        System.out.println(list.size());
        for (Object o : list) {
            System.out.println(o);
        }
//        list.get(0);
//        list.remove("");
//        list.contains("");
//        list.size();
//        list.hashCode();
//        list.equals("");
    }
}
