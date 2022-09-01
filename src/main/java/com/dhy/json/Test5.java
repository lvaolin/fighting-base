package com.dhy.json;

/**
 * @Project fighting-core
 * @Description 变长参数原理
 * @Author lvaolin
 * @Date 2022/9/1 上午11:23
 */
public class Test5 {

    public static void main(String[] args) {
        String[] arr = {"a","b"};
        method(arr);

        String c = "c";
        String d = "d";
        method(c,d);
    }

    public static void method(String ... name){
        for (String s : name) {
            System.out.println(s);
        }
    }


}
