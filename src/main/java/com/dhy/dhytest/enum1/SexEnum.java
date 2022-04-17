package com.dhy.dhytest.enum1;

import java.util.Arrays;

public enum SexEnum {
    MAN(1,"男"),WOMEN(2,"女");

    private int code;
    private String name;
    private SexEnum(int code,String name){
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "SexEnum{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }


    public static void main(String[] args) {
        System.out.println(SexEnum.MAN.ordinal());
        System.out.println(SexEnum.MAN.code);
        System.out.println(SexEnum.MAN.name);

        SexEnum man = SexEnum.valueOf("MAN");
        System.out.println(man.equals(SexEnum.MAN));

        Arrays.stream(SexEnum.values()).forEach((e)->{
            System.out.println(e.toString());
        });
    }
}
