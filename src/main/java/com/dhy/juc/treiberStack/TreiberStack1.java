package com.dhy.juc.treiberStack;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 一个基于CAS实现的无锁（lock-free）并发栈
 **/  
public class TreiberStack1<E> {
    //栈顶指针
    private AtomicReference<Node<E>> top = new AtomicReference<Node<E>>();
  
    /** 
     * 添加到栈顶 
     * @param item 
     */  
    public void push(E item) {  
        Node<E> header = new Node<E>(item);  
        Node<E> currentHead;  
        do {  
            currentHead = top.get();  
            header.next = currentHead;  
        } while (!top.compareAndSet(currentHead, header));  
    }  
  
    /** 
     * 弹出栈顶 
     * @return 
     */  
    public E pop() {  
        Node<E> currentHead;  
        Node<E> header;  
        do {  
            currentHead = top.get();  
            if (currentHead == null)  
                return null;  
            header = currentHead.next;  
        } while (!top.compareAndSet(currentHead, header));  
        return currentHead.item;  
    }  
  
    private static class Node <E> {  
        public final E item;  
        public Node<E> next;  
  
        public Node(E item) {  
            this.item = item;  
        }  
    }


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        int count = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        TreiberStack1<String> stack2 = new TreiberStack1<>();
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
                    System.out.println("push end");
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(3);
        for (int i = 0; i < count; i++) {
            System.out.println(stack2.pop());
        }

        while (true);
    }
}  