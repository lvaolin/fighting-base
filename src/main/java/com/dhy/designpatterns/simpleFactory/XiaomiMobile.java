package com.dhy.designpatterns.simpleFactory;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/17 下午5:43
 */
public class XiaomiMobile implements Mobile {
    @Override
    public String getBrand() {
        return "xiaomi";
    }
}
