package com.dhy.designpatterns.proxy.demo3;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/2/10 下午3:55
 */
public class Main {
    public static void main(String[] args) {
        BigObjectInterface proxy = new BigObjectProxy();
        System.out.println(proxy.m1("nnnnn"));
        System.out.println(proxy.m1("111111"));
    }
}
