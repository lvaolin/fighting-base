package com.dhy.designpatterns.proxy.demo1;

/**
 * @Title Client1
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 19:05
 **/
public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new ServiceImpl1());
        String resullt = proxy.method1();
        System.out.println("结果："+resullt);
    }
}
