package com.dhy.juc.atom;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    public static void main(String[] args) {
        AtomicReference<Object> objectAtomicReference = new AtomicReference<>();
        System.out.println(objectAtomicReference.get());
        objectAtomicReference.set(new Object());
        System.out.println(objectAtomicReference.get());
        objectAtomicReference.getAndSet(new Object());
        System.out.println(objectAtomicReference.get());


    }
}
