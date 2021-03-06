package com.dhy.proxy.jdk0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ListProxy {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        List listProxy = (List<String>)Proxy.newProxyInstance(
                ArrayList.class.getClassLoader(),
                ArrayList.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("=========proxy=========");
                        if (method.getName().equals("add")) {
                            System.out.println("add 操作");
                        }
                        if (method.getName().equals("get")) {
                            System.out.println("get 操作");
                        }
                        return method.invoke(list, args);
                    }
                }
        );

        listProxy.add("1");
        System.out.println(listProxy.get(0));

    }

}
