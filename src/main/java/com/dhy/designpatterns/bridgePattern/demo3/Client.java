package com.dhy.designpatterns.bridgePattern.demo3;

/**
 * @Project fighting-core
 * @Description 客户端测试
 * @Author lvaolin
 * @Date 2022/8/14 下午10:21
 */
public class Client {
    public static void main(String[] args) {
        AbstractPay pay1 = new AliPay(new PaymentFace());
        pay1.pay();

        AbstractPay pay2 = new WeXinPay(new PaymentPassword());
        pay2.pay();

    }
}
