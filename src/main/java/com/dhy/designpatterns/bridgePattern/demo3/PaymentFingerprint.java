package com.dhy.designpatterns.bridgePattern.demo3;

/**
 * @Project fighting-core
 * @Description 指纹支付
 * @Author lvaolin
 * @Date 2022/8/14 下午10:13
 */
public class PaymentFingerprint implements Payment {
    @Override
    public void method() {
        System.out.println("指纹验证通过");
    }
}
