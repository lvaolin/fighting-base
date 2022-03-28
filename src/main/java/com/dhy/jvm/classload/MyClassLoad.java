package com.dhy.jvm.classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.regex.Matcher;

/**
 *
 * 1、继承 ClassLoader 类
 * 2、覆盖 findClass 方法
 * （通过 File 类把 class文件读取到内存 ，转换成 字节数组 byte[]，再通过父类的 defineClass方法 实例化后返回 Class）
 * 3、classFilePath 不能和 AppClassLoad的classpath相同(根据双亲委派模型，优先加载父加载器里的同名类，自定义加载器的父加载器是AppClassLoad)，
 * 否则需要的类会被AppClassLoad加载进来（MyClassLoad的parent是AppClassLoad）
 * 4、也就是说自定义类加载器需要把类放到JVM classpath之外的一个目录中
 */
public class MyClassLoad extends ClassLoader{
    private String classPath;

    public MyClassLoad(String classPath) {
        this.classPath = classPath;
    }

    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name
                + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;

    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }


    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = new MyClassLoad("/Users/lvaolin/Downloads/classes");
        Class<?> aClass = classLoader.loadClass("com.dhy.cas.Singleton");

        for (Method declaredMethod : aClass.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }

        System.out.println(aClass.getClassLoader());
        System.out.println(classLoader.getClass().getClassLoader());
        System.out.println(aClass.getClassLoader().getParent());
    }
}
