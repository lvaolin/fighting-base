package com.dhy.juc.lambda;

import java.util.function.*;

/**
 * @Title TestSupplier
 * @Description
 * @Author lvaolin
 * @Date 2021/2/14 21:22
 **/
public class TestSupplier {

    public static void main(String[] args) {
        //测试供应者，DoubleSupplier没有输入参数，返回一个Double类型的数值
        DoubleSupplier doubleSupplier = ()->{
          return 100;
        };

        double asDouble = doubleSupplier.getAsDouble();
        //消费一个 Double类型的 数值，没有返回值
        DoubleConsumer doubleConsumer=(d)->{
            System.out.println(2*d);
        };

        doubleConsumer.accept(asDouble);

        BooleanSupplier booleanSupplier = ()->{
          return true;
        };

        System.out.println(booleanSupplier.getAsBoolean());

        IntSupplier intSupplier =()->{
            return 1;
        };

        System.out.println(intSupplier.getAsInt());



    }
}
