package com.dhy.designpatterns.proxy.demo3;

/**
 * @Project fighting-core
 * @Description 大对象
 * @Author lvaolin
 * @Date 2022/2/10 下午3:52
 */
public class BigObjectService implements BigObjectInterface{
    @Override
    public String m1(String name) {
        return "reply:"+name;
    }
}
