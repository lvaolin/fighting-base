package com.dhy.designpatterns.IteratorPattern.demo1;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 迭代器模式核心思路：
 * 1、定义容器接口MyCollection，里面除了容器本身的增删方法外，还有一个获取迭代器的方法 iterator()
 * 2、定义一个迭代器接口MyIterator，里面至少有  hasNext()和 next() 方法
 * 3、定义容器实现类 MyList
 * 4、在容器实现类内部定义 迭代器实现类（内部类） MyListIterator 实现 MyIterator 接口
 * 5、
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {

        MyCollection myList = new MyList();
        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("d");
        myList.add("e");

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    MyIterator iterator1 = myList.iterator();
                    while (iterator1.hasNext()) {

                        TimeUnit.SECONDS.sleep( ThreadLocalRandom.current().nextInt(3));
                        Object next = iterator1.next();
                        System.out.println(Thread.currentThread().getName()+next);
                    }
                }
            }).start();
        }
        new CountDownLatch(1).await();
    }
}
