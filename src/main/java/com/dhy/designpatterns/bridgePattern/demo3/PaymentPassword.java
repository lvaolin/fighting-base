package com.dhy.designpatterns.bridgePattern.demo3;

/**
 * @Project fighting-core
 * @Description 密码支付
 * @Author lvaolin
 * @Date 2022/8/14 下午10:13
 */
public class PaymentPassword implements Payment {
    @Override
    public void method() {
        System.out.println("密码验证通过");
    }
}
