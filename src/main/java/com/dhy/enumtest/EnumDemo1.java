package com.dhy.enumtest;

/**
 * @Project fighting-core
 * @Description 枚举的本质还是一个类，枚举值 就是一个个类实例
 * @Author lvaolin
 * @Date 2022/5/28 下午5:51
 */
public enum  EnumDemo1 {
    man,women
}

class Test{
    public static void main(String[] args) {
        EnumDemo1 man1 = EnumDemo1.man;
        EnumDemo1 man = EnumDemo1.valueOf("man");//默认值和名称一致

        System.out.println(man1 == man);

        EnumDemo1[] values = EnumDemo1.values();
        for (EnumDemo1 value : values) {
            System.out.println(value);
        }

    }
}