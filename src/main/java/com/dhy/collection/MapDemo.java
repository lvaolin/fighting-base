package com.dhy.collection;

import java.util.*;
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
        Map<String,String> map = new HashMap<String,String>();
        map.put(null,null);
        map.put(null,null);
        map.put("1",null);

        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(null,null);
        concurrentHashMap.put(null,null);
        concurrentHashMap.put("1",null);

        List<Object> list = new ArrayList<>();
        list.add(null);
        list.add(null);

        Set set = new HashSet();
        set.add(null);
        set.add(null);
        set.add(null);
    }
}
