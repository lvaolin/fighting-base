package com.dhy.proxy.jdk1;

import com.dhy.proxy.jdk1.target1.Hello;
import com.dhy.proxy.jdk1.target1.Person;

/**
 * @author lvaolin
 * @create 2020/4/14 9:33 AM
 */
public class Factory {
    //方式1（复杂对象）：将对象key传进来
    public  static <R>  R  getInstance(String key){
        switch (key){
            case "person":
                return (R)java.lang.reflect.Proxy.newProxyInstance(Person.class.getClassLoader(),Person.class.getInterfaces(),new MyProxy(new Person()));
            case "hello":
                return (R)java.lang.reflect.Proxy.newProxyInstance(Hello.class.getClassLoader(),Hello.class.getInterfaces(),new MyProxy(new Hello()));
            default:
                return null;
        }
    }

    //方式2（简单对象）：将对象传进来
    public  static  <R>  R  getInstance(Object object){
        return (R)java.lang.reflect.Proxy.newProxyInstance(Person.class.getClassLoader(),Person.class.getInterfaces(),new MyProxy(object));
    }
}
