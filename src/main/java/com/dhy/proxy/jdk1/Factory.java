package com.dhy.proxy.jdk1;

import com.dhy.proxy.jdk1.target.Hello;
import com.dhy.proxy.jdk1.target.Person;

/**
 * @author lvaolin
 * @create 2020/4/14 9:33 AM
 */
public class Factory {
    //方式1（复杂对象）：将对象key传进来
    public  static  Object  getInstance(String key){
        switch (key){
            case "person":
                return java.lang.reflect.Proxy.newProxyInstance(Person.class.getClassLoader(),Person.class.getInterfaces(),new MyProxy(new Person()));
            case "hello":
                return java.lang.reflect.Proxy.newProxyInstance(Hello.class.getClassLoader(),Hello.class.getInterfaces(),new MyProxy(new Hello()));
            default:
                return null;
        }
    }

    //方式2（简单对象）：将对象传进来
    public  static  Object  getInstance(Object object){
        return java.lang.reflect.Proxy.newProxyInstance(Person.class.getClassLoader(),Person.class.getInterfaces(),new MyProxy(object));
    }
}
