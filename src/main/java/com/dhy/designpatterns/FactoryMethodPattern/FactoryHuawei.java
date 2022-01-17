package com.dhy.designpatterns.FactoryMethodPattern;

/**
 * @Project fighting-core
 * @Description 生成华为音乐播放器
 * @Author lvaolin
 * @Date 2022/1/17 下午3:10
 */
public class FactoryHuawei implements IFactory {
    @Override
    public IProduct getProduct() {
        return new ProductHuawei();
    }
}
