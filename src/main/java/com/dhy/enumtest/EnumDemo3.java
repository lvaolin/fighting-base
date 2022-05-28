package com.dhy.enumtest;

/**
 * @Project fighting-core
 * @Description  枚举的本质还是一个类，枚举值 就是一个个类实例
 *
 * 枚举值比常量值好的地方是  可以携带额外信息，code，desc等---
 *
 * @Author lvaolin
 * @Date 2022/5/28 下午5:58
 */
public enum  EnumDemo3 {
    man("1","男人"),women("0","女人"),XXX;

    EnumDemo3(){

    }

    private String code;
    private String desc;
    EnumDemo3(String code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
class Test3 {
    public static void main(String[] args) {
        EnumDemo3 man1 = EnumDemo3.man;
        EnumDemo3 man = EnumDemo3.valueOf("man");//默认值和名称一致
        System.out.println(man1 == man);

        EnumDemo3[] values = EnumDemo3.values();
        for (EnumDemo3 value : values) {
            System.out.println(value+","+value.name()+","+value.getCode());
        }

        //像普通类一样调用方法，再次证明枚举值就是一个类实例
        System.out.println(man1.name()+","+man1.getCode()+","+man1.getDesc());

    }
}