package com.dhy.juc.atom;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;
//ABA测试
public class AtomicStampedReferenceTest {

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        AtomicStampedReference<Object> stampedReference = new AtomicStampedReference<>(a, 0);
        System.out.println(stampedReference.getReference());

        new Thread(()->{
            stampedReference.compareAndSet(a,b,0,1);//换成对象
            stampedReference.compareAndSet(b,a,1,2);//再换回a对象
        }).start();

        TimeUnit.SECONDS.sleep(3);
        stampedReference.compareAndSet(a,b,0,1);//换成b对象，版本不对，不会成功
        System.out.println(stampedReference.getReference());


    }
}
