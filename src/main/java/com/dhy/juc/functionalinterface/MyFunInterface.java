package com.dhy.juc.functionalinterface;

import java.util.Comparator;

@FunctionalInterface
public interface MyFunInterface {
    String print(String msg);
}

class MyFunInterfaceTest {
    public static void main(String[] args) {

        MyFunInterfaceTest main = new MyFunInterfaceTest();
        main.test((String s)-> s+"hello");
        main.test((String x)->{
            return x+"world";
        });


        Runnable task = () -> {
            // do something
        };

        Comparator<String> cmp = (s1, s2) -> {
            return Integer.compare(s1.length(), s2.length());
        };


        MyFunInterface myFunInterface = (msg)->{
            System.out.println(msg);
            return "hello function inteface "+msg;
        };

        myFunInterface.print("dahuangya");
    }

    void test(MyFunInterface myFunInterface){
        System.out.println("befire xxx");
        System.out.println(myFunInterface.print("大哥"));
        System.out.println("after xxx");
    }
}