package com.dhy.juc.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Project fighting-core
 * @Description Stream of
 * @Author lvaolin
 * @Date 2022/2/11 下午2:21
 */
public class Test1 {
    public static void main(String[] args) {
        //求和
        int sum1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter((x) -> x > 5)
                .mapToInt((x) -> x)
                .sum();

        System.out.println(sum1);

        //字符串转数字 求和
        int sum = Stream.of("1", "2", "3")
                .mapToInt((x) -> Integer.parseInt(x))
                .sum();

        System.out.println(sum);

        //字符串转数字求和
        int sum2 = Stream.of("1,2,3", "4,5,6", "7,8,9")
                .flatMapToInt(row -> {
                    return Arrays.stream(row.split(","))
                            .mapToInt(x -> Integer.parseInt(x));

                }).sum();

        System.out.println(sum2);


        Integer reduce = Stream.of(1, 2, 3).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);

    }
}
