package com.dhy.theadlocal.memoryleak;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * @Project fighting-core
 * @Description 反射工具
 * @Author lvaolin
 * @Date 2023/4/2 下午6:40
 */
public class MyReflectUtil {

    /**
     * 打印当前线程上关联的ThreadLocalMap容量和条目数量（包括有效和无效条目）
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void printThreadLocalMapSize() throws NoSuchFieldException, IllegalAccessException {
        Thread thread = Thread.currentThread();
        Field threadLocalsField = Thread.class.getDeclaredField("threadLocals");
        threadLocalsField.setAccessible(true);
        Object threadLocals = threadLocalsField.get(thread);

        Field tableField = threadLocals.getClass().getDeclaredField("table");
        tableField.setAccessible(true);
        Object entryArr = tableField.get(threadLocals);
        int length = Array.getLength(entryArr);//threadLocalMap  length

        Field sizeField = threadLocals.getClass().getDeclaredField("size");
        sizeField.setAccessible(true);
        Object size = sizeField.get(threadLocals);//threadLocalMap  size
        System.out.println("threadLocalMap：length->"+length+",size->"+size);
    }
}
