package com.dhy.designpatterns.templete.task;

/**
 * @Title Client1
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 18:44
 **/
public class Client {

    public static void main(String[] args) {

        AbstractJob myJob1 = new MyJob1();
        myJob1.templeteMethod();

        AbstractJob yourJob1 = new YourJob1();
        yourJob1.templeteMethod();
    }
}
