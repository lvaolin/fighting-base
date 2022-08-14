package com.dhy.designpatterns.bridgePattern.demo3;

/**
 * @Project fighting-core
 * @Description 人脸支付
 * @Author lvaolin
 * @Date 2022/8/14 下午10:13
 */
public class PaymentFace implements Payment {
    @Override
    public void method() {
        System.out.println("人脸验证通过");
    }
}
