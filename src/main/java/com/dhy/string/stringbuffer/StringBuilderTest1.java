package com.dhy.string.stringbuffer;

/**
 * stringBuilder
 * 1、多线程安全性
 * 2、缓冲区
 * 3、性能
 *
 */
public class StringBuilderTest1 {
    public static void main(String[] args) throws InterruptedException {

        StringBuilder stringBuilder  = createBigSQL1(10000);
        String result1 = stringBuilder.toString();
        String result2 = stringBuilder.toString();
        String result3 = stringBuilder.toString();
        System.out.println("okl");
        while (true);
    }
    private static StringBuilder createBigSQL1(int count) throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append("INSERT INTO Customers VALUES(1000000006,'Toy Land','123 Any Street','New York','NY','11111','USA',NULL,NULL,hello world);");
        }
        return stringBuilder;
    }

}
