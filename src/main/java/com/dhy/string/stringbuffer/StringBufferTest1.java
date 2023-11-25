package com.dhy.string.stringbuffer;

import java.util.concurrent.TimeUnit;

/**
 * StringBuffer
 * 1、多线程安全性
 * 2、缓冲区
 * 3、性能
 *
 */
public class StringBufferTest1 {
    public static void main(String[] args) throws InterruptedException {

//        StringBuffer stringBuffer  = createBigSQL1(10000);
//        String result1 = stringBuffer.toString();
//        System.out.println("okl");
//        while (true);

        String string  = createBigSQL2(10000);
        System.out.println("okl");
        while (true);
    }

    private static StringBuffer createBigSQL1(int count) throws InterruptedException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < count; i++) {
            stringBuffer.append("INSERT INTO Customers VALUES(1000000006,'Toy Land','123 Any Street','New York','NY','11111','USA',NULL,NULL,hello world);");
        }
        return stringBuffer;
    }
    private static String createBigSQL2(int count) throws InterruptedException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < count; i++) {
            stringBuffer.append("INSERT INTO Customers VALUES(1000000006,'Toy Land','123 Any Street','New York','NY','11111','USA',NULL,NULL,hello world);");
        }
        return stringBuffer.toString();
    }
}
