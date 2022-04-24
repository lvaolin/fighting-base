package com.dhy.juc.treiberStack;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class MyStack<T>{
    private MyNode<T> head;
    synchronized void push(T t){
        if (head==null) {
            head = new MyNode<>(t);
        }else{
            MyNode<T> newHead = new MyNode<>(t);
            newHead.next = head;
            head = newHead;
        }

    }

    synchronized T pop(){
        if (head ==null) {
            return null;
        }
        MyNode oldHead = head;
        MyNode next = head.next;
        if (next!=null) {
            head = head.next;
        }else{
            head = null;
        }
        return (T)oldHead.t;
    }

    static class MyNode<T>{
        public MyNode(T t){
            this.t = t;
        }
        public T t;
        public MyNode next;
    }



    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(100);
        MyStack<String> stringMyStack = new MyStack<>();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    stringMyStack.push(finalI+"");
                }
            }).start();
        }

        cyclicBarrier.await();

        for (int i = 0; i < 90; i++) {
            System.out.println(stringMyStack.pop());
        }

        while (true);
    }
}

