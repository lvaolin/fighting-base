package com.dhy.proxy.jdk2;


import com.dhy.proxy.jdk2.target2.IPerson;
import com.dhy.proxy.jdk2.target2.Person;

public class Client1 {
    public static void main(String[] args)  {
        IPerson person = MyProxyFactory.getInstance(new Person("大黄鸭"));
        person.eat();
    }
}
