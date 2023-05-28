package com.dhy.designpatterns.simpleFactory;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/1/17 下午5:44
 */
public class Client {
    public static void main(String[] args) {
        Mobile appleMobile = MobileFactory.getMobile("apple");
        System.out.println(appleMobile.getBrand());
        Mobile huaweiMobile = MobileFactory.getMobile("huawei");
        System.out.println(huaweiMobile.getBrand());
        Mobile xiaomiMobile = MobileFactory.getMobile("xiaomi");
        System.out.println(xiaomiMobile.getBrand());
        Mobile oppoMobile = MobileFactory.getMobile("oppo");
        System.out.println(oppoMobile.getBrand());
    }
}
