package com.dhy.designpatterns.singleton;

/**
 * @Project fighting-core
 * @Description 使用枚举实现 单例模式
 * @Author lvaolin
 * @Date 2022/5/28 下午6:16
 */
public class Dahuangya {
    public void gaga(){
        System.out.println("gaga");
    }
}

enum MyEnum{
    dahuangya;
    public Dahuangya d = new Dahuangya();
}

class Test{
    public static void main(String[] args) {
        MyEnum.dahuangya.d.gaga();
    }
}