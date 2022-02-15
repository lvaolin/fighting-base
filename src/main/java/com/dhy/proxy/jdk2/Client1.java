package com.dhy.proxy.jdk2;

import com.dhy.proxy.jdk1.target.IPerson;
import com.dhy.proxy.jdk1.target.Person;

public class Client1 {
    public static void main(String[] args)  {
        IPerson person = (IPerson) MyProxyFactory.getInstance(new Person());
        person.eat();
    }
}
