package com.dhy.designpatterns.simpleFactory;

/**
 * @Project fighting-core
 * @Description 简单工厂， 没有工厂接口
 * @Author lvaolin
 * @Date 2022/1/17 下午5:39
 */
public class MobileFactory {

    Mobile getMobile(String brand){

        switch (brand){
            case "apple":
                return new AppleMobile();
            case "huawei":
                return new HuaweiMobile();
            case "xiaomi":
                return new XiaomiMobile();
            default:return new OppoMobile();
        }
    }
}
