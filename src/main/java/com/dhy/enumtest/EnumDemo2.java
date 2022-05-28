package com.dhy.enumtest;

/**
 * @Project fighting-core
 * @Description  枚举的本质还是一个类，枚举值 就是一个个类实例
 * @Author lvaolin
 * @Date 2022/5/28 下午5:58
 */

public enum  EnumDemo2 {
    man("男人"),women("女人"), XXX;

    public String getDesc() {
        return desc;
    }

    EnumDemo2(){
    }

    private String desc;
    //声明一个带参数的构造方法
    EnumDemo2(String desc){
        this.desc = desc;
    }
}

class Test2{
    public static void main(String[] args) {
        EnumDemo2 man1 = EnumDemo2.man;
        EnumDemo2 man = EnumDemo2.valueOf("man");//默认值和名称一致
        System.out.println(man1 == man);

        EnumDemo2[] values = EnumDemo2.values();
        for (EnumDemo2 value : values) {
            System.out.println(value);
        }

        //像普通类一样调用方法，再次证明枚举值就是一个类实例
        System.out.println(man1.getDesc());

    }
}
