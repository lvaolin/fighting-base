package com.dhy.fanxing.demo8;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project fighting-core
 * @Description
 * 下界通配符 < ? super E>
 * 场景应用好像有限。。。
 * @Author lvaolin
 * @Date 2022/5/28 下午1:43
 */
public class Demo8 {
    //复制集合对象
    private <T> void test(List<? super T> target, List<T> src){
        for (T t : src) {
            target.add(t);
        }
    }



    public static void main(String[] args) {
        List<Dog> src = new ArrayList<>();
        List<Animal> target = new ArrayList<>();

        new Demo8().test(target,src);
    }


}
