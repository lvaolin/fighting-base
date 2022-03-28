package com.dhy.jvm.classload;

import javax.servlet.Servlet;
import java.sql.DriverManager;

/**
 * 使用app class load 加载指定的类
 */
public class Dhy001ClassLoad {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Dhy001ClassLoad.class.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(Thread.currentThread().getContextClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(String.class.getClassLoader());//null 表示是 BootstreapClassLoad
        System.out.println(DriverManager.class.getClassLoader());//null
        System.out.println(Servlet.class.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(Dhy001ClassLoad.class.getClassLoader().getParent());//sun.misc.Launcher$ExtClassLoader@33e5ccce
        System.out.println(Dhy001ClassLoad.class.getClassLoader().getParent().getParent());//null
        Class clazz = Dhy001ClassLoad.class.getClassLoader().loadClass("com.dhy.temp.Person");
        Class<?> aClass1 = Class.forName("com.dhy.temp.Person");//默认使用当前类的类加载器
        Class<?> aClass2 = Servlet.class.getClassLoader().loadClass("com.dhy.temp.Person");
       // Class<?> aClass = String.class.getClassLoader().loadClass("com.dhy.temp.Person");

    }
}
