package com.dhy.money;

import java.math.BigDecimal;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/3/25 下午4:46
 */
public class BigDecDemo {
    public static void main(String[] args) {
        System.out.println(0.1 + 0.2);
        System.out.println(MoneyUtil.moneyAdd(new BigDecimal("0.1"),new BigDecimal("0.2")));
        System.out.println(0.2 - 0.1);
        System.out.println(MoneyUtil.moneySub(new BigDecimal("0.2"),new BigDecimal("0.1")));
        System.out.println(0.1 * 0.2);
        System.out.println(MoneyUtil.moneyMul(new BigDecimal("0.1"),new BigDecimal("0.2")));
        System.out.println(0.2 / 0.1);
        System.out.println(MoneyUtil.moneyDiv(new BigDecimal("0.2"),new BigDecimal("0.1")));
        System.out.println(0.3 - 0.1);
        System.out.println(MoneyUtil.moneySub(new BigDecimal("0.3"),new BigDecimal("0.1")));
        System.out.println(0.3 / 0.1);
        System.out.println(MoneyUtil.moneyDiv(new BigDecimal("0.3"),new BigDecimal("0.1")));


    }
}
