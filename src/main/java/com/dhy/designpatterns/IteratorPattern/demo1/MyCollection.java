package com.dhy.designpatterns.IteratorPattern.demo1;

public interface MyCollection {
    void add(Object o);
    boolean remove(Object o);
    int size();
    Object get(int index);
    MyIterator iterator();
}
