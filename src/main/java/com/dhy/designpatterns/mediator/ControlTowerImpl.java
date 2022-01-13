package com.dhy.designpatterns.mediator;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/13 下午6:31
 */
public class ControlTowerImpl implements IControlTower {
    //注册的飞机
    private List<IAirplane> airplaneList=new CopyOnWriteArrayList<>();

    //跑到与飞机映射关系
    private Map<String,IAirplane> map = new HashMap<>();
    {
        map.put("1号跑道",null);
        map.put("2号跑道",null);
    }
    @Override
    public void add(IAirplane airplane){
        airplaneList.add(airplane);
    }
    @Override
    public void remove(IAirplane airplane){
        airplaneList.remove(airplane);
    }

    @Override
    public String call(IAirplane airplane, String event) {
        if (!airplaneList.contains(airplane)) {
            throw new RuntimeException("未注册");
        }
        Iterator<Map.Entry<String, IAirplane>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, IAirplane> next = iterator.next();
            if (next.getValue()==null) {
                next.setValue(airplane);
                return next.getKey();
            }
        }

        throw new RuntimeException("无空闲跑道");
    }
}
