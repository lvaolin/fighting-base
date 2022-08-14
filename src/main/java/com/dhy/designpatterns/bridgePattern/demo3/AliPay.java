package com.dhy.designpatterns.bridgePattern.demo3;

/**
 * @Project fighting-core
 * @Description 阿里支付
 * @Author lvaolin
 * @Date 2022/8/14 下午10:11
 */
public class AliPay extends AbstractPay {
    public AliPay(Payment payment) {
        super(payment);
    }

    @Override
    public boolean pay() {
        System.out.println("阿里支付开始");
        super.getPayment().method();
        System.out.println("阿里支付成功");
        return true;
    }
}
