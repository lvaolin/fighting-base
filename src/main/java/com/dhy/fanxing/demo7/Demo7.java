package com.dhy.fanxing.demo7;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project fighting-core
 * @Description 证明  通配符 ？ 的好处
 * 上界通配符 < ? extends E>
 *
 * @Author lvaolin
 * @Date 2022/5/28 下午1:43
 */
public class Demo7 {
    static int countLegs(List<? extends Animal> animals) {
        int retVal = 0;
        for (Animal animal : animals) {
            retVal += animal.countLegs();
        }
        return retVal;
    }


    static int countLegs1(List<Animal> animals) {
        int retVal = 0;
        for (Animal animal : animals) {
            retVal += animal.countLegs();
        }
        return retVal;
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        //用了通配符 不会报错
        countLegs(dogs);
        // 报错
       // countLegs1(dogs);
    }
}
