package com.dhy.juc.treiberStack;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class MyStack2<T> {
    private  AtomicReference<MyNode<T>> top = new AtomicReference<>();

    public void push(T item){
        int count = 0;
        //old  head
        MyNode oldHead ;
        //new head
        MyNode newHead = new MyNode(item);
        do{
            count++;
            oldHead = top.get();
            newHead.next = oldHead;
        }while (!top.compareAndSet(oldHead,newHead));

        System.out.println(Thread.currentThread().getName()+"push success "+count);
    }

    public T pop(){
        int count = 0;

        //old  head
        MyNode<T> oldHead ;
        //new head
        MyNode<T> newHead ;

        do{
            count++;
            oldHead =  top.get();
            if (oldHead ==null) {
                return null;
            }
            newHead = oldHead.next;
        }while (!top.compareAndSet(oldHead,newHead));
        System.out.println(Thread.currentThread().getName()+"pop success "+count);
        return oldHead.item;
    }


    static class MyNode<T>{
        public T item;
        public MyNode<T> next;
        public MyNode(T item){
            this.item = item;
        }
    }


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        int count = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        MyStack2<String> stack2 = new MyStack2<>();
        for (int i = 0; i < count; i++) {
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
                    stack2.push(finalI +"");
                }
            }).start();
        }


        TimeUnit.SECONDS.sleep(3);
        for (int i = 0; i < count+2; i++) {
            System.out.println(stack2.pop());
        }

        while (true);
    }
}
