package com.dhy.designpatterns.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Project fighting-core
 * @Description 享元工厂，其实就是一个Cache管理器
 * @Author lvaolin
 * @Date 2022/1/17 下午6:45
 */
public class FlyweightFactory {
    private Map<String,BulletBase> bulletBaseMap = new ConcurrentHashMap<>();

    public BulletBase getBulletBase(String color){
        BulletBase bulletBase = bulletBaseMap.get(color);
        if (bulletBase==null) {
            synchronized (FlyweightFactory.class){
                bulletBase = new BulletBase("2cm", "100g", "ak47", color);
                bulletBaseMap.putIfAbsent(color,bulletBase);
            }
        }
        return bulletBase;
    }
}
