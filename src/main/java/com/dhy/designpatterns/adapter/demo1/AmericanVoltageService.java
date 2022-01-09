package com.dhy.designpatterns.adapter.demo1;

/**
 * @Title AmericanVoltageService
 * @Description  美国电压服务接口
 * @Author lvaolin
 * @Date 2022/1/9 15:59
 **/
public class AmericanVoltageService implements IAmericanVoltageService {
    @Override
    public boolean charging110(int v){
        if (v==110) {
            System.out.println("充电中。。。。");
            return true;
        }else{
            System.out.println("电压不兼容，充电失败。。。。");
            return false;
        }
    }
}
