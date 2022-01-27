package com.dhy.designpatterns.IteratorPattern;

public interface MyCollection {
    void add(Object o);
    boolean remove(Object o);
    int size();
    Object get(int index);
    MyIterator iterator();
}
