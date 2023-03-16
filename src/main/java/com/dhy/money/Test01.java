package com.dhy.money;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

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
        System.out.println(new BigDecimal("1.2").subtract(new BigDecimal(0.01),new MathContext(1)));
        //1
        System.out.println(new BigDecimal("1.2").subtract(new BigDecimal(0.01),new MathContext(2)));
        //1.2
        System.out.println(new BigDecimal("1.2").subtract(new BigDecimal(0.01),new MathContext(3)));
        //1.19
        System.out.println(new BigDecimal("1.2").subtract(new BigDecimal(0.01),new MathContext(3, RoundingMode.DOWN)));
        //1.18
        System.out.println(new BigDecimal("1.2").subtract(new BigDecimal("0.01")));
        //1.19
        new BigDecimal(1L);
        new BigDecimal(1);
        new BigDecimal(0.1);
        new BigDecimal(0.01,new MathContext(2));
        new BigDecimal(new BigInteger("100"));
        new BigDecimal('a');
        //new BigDecimal(new char[]{'a','b'});

    }
}
