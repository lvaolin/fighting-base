package com.dhy.money;

import java.math.BigDecimal;

/**
 * @Project fighting-core
 * @Description BigDecimal初始化"字符串"与"小数"的区别
 * @Author lvaolin
 * @Date 2023/3/15 上午8:30
 */
public class Test01 {

    public static void main(String[] args) {
        System.out.println(new BigDecimal("1.2").subtract(new BigDecimal(0.01)));
        //1.18999999999999999979183318288278314867056906223297119140625
        System.out.println(new BigDecimal("1.2").subtract(new BigDecimal("0.01")));
        //1.19
    }
}
