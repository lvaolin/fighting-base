package com.dhy.designpatterns.bridgePattern.demo3;

/**
 * @Project fighting-core
 * @Description 支付品牌抽象类
 * @Author lvaolin
 * @Date 2022/8/14 下午10:07
 */
public  abstract class AbstractPay {
    private Payment payment;

    public AbstractPay(Payment payment) {
        this.payment = payment;
    }

    public abstract boolean pay();

    public Payment getPayment() {
        return payment;
    }
}
