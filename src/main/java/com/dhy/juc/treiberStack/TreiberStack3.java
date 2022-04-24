package com.dhy.juc.treiberStack;

import lombok.SneakyThrows;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Project fighting-core
 * @Description 特累贝尔 栈
 * @Author lvaolin
 * @Date 2022/4/16 下午12:06
 */
public class TreiberStack3<T> {

    /**
     * 栈顶指针
     */
    private AtomicReference<Node<T>> top = new AtomicReference<Node<T>>();

    /**
     * 入栈
     * @param data
     */
    public void push(T data){
        int counter = 0;
        Node oldHeader;
        Node newHeader = new Node(data);
        do{
            counter++;
            oldHeader = top.get();
            newHeader.next = oldHeader;
        }while (!top.compareAndSet(oldHeader,newHeader));
        System.out.println(Thread.currentThread().getName()+" try push "+counter+"次，data："+data.toString());
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        int counter = 0;
        Node<T> oldHeader ;
        Node<T> newHeader ;
        do{
            counter++;
            oldHeader = top.get();
            if (oldHeader==null) {
                return null;
            }
            newHeader = oldHeader.next;
        }while (!top.compareAndSet(oldHeader,newHeader));
        System.out.println(Thread.currentThread().getName()+" try pop "+counter+"次，data："+oldHeader.data.toString());
        return oldHeader.data;
    }

    class Node<T>{
        public T data;
        public Node next;

        public Node(T data){
            this.data = data;
        }

    }


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        int count = 5;
        System.out.println("----------------PUSH----------------------------------");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        TreiberStack3<String> treiberStack3 = new TreiberStack3<>();
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
                    treiberStack3.push(finalI +"");
                }
            }).start();
        }


        TimeUnit.SECONDS.sleep(3);
        System.out.println("----------------POP----------------------------------");
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(count);
        for (int i = 0; i < count; i++) {
           // treiberStack3.pop();
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    cyclicBarrier1.await();
                    treiberStack3.pop();
                }
            }).start();

        }

        while (true);
    }
}
