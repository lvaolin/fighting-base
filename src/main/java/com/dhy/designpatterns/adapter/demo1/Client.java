package com.dhy.designpatterns.adapter.demo1;

/**
 * @Title Client
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 16:07
 **/
public class Client {

    public static void main(String[] args) {

        //美国的充电服务
        IAmericanVoltageService americanVoltageService = new AmericanVoltageService();

        //中国手机充电适配器
        IChinaMobile chinaMobileAdapter = new ChinaMobileAdapter(americanVoltageService);

        if (chinaMobileAdapter.charging220(220)) {
            System.out.println("充电成功");
        }else{
            System.out.println("充电失败");
        }


    }
}
