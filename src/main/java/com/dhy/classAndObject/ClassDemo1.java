package com.dhy.classAndObject;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @Project fighting-core
 * @Description  深入理解 Class 类和Object类
 * @Author lvaolin
 * @Date 2022/3/27 下午1:53
 */
public class ClassDemo1 {
    public static void main(String[] args) {

        Class demo2 = ClassDemo1.class;
        Class c = ReentrantLock.class;
        Object obj= new ReentrantLock();

        if (obj.getClass()==c) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        if (c.getClassLoader()==obj.getClass().getClassLoader()) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }

}

