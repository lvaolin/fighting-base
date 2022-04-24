package com.dhy.juc.lambda;

import java.util.function.Function;

/**
 * @Title TestFunction
 * @Description  一个输入参数， 有返回值
 * @Author lvaolin
 * @Date 2021/2/14 22:02
 **/
public class TestFunction {

    public static void main(String[] args) {

        Function<String,String> function = (s)->{
            return s+s;
        };

        System.out.println(function.apply("hello function "));
    }
}
