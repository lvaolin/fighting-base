package com.dhy.juc.lambda;

import java.util.function.BiConsumer;

/**
 * @Title TestBiConsumer
 * @Description  消费者实例
 * @Author lvaolin
 * @Date 2021/2/14 21:55
 **/
public class TestBiConsumer {

    public static void main(String[] args) {



        BiConsumer<Integer,Integer> biConsumer = (t,u)->{
            System.out.println(t+u);
        };

        biConsumer.accept(100,200);


    }
}
