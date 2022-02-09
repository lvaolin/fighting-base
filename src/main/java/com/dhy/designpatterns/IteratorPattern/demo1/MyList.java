package com.dhy.designpatterns.IteratorPattern.demo1;

import java.util.ArrayList;
import java.util.List;

public class MyList implements  MyCollection{

    private List list = new ArrayList();
    @Override
    public void add(Object o) {
         list.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Object get(int index) {
        return list.get(index);
    }


    @Override
    public MyIterator iterator() {
        return new MyListIterator(this);
    }

    class MyListIterator implements MyIterator{

        private MyList list;
        private int currentIndex = 0;
        public MyListIterator( MyList list){
            this.list = list;
        }
        @Override
        public boolean hasNext() {
            return list.size()>0&&currentIndex<list.size();
        }

        @Override
        public Object next() {
            return list.get(currentIndex++);
        }
    }
}
