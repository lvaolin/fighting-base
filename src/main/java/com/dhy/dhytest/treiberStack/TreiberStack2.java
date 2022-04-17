package com.dhy.dhytest.treiberStack;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 基于Unsafe实现TreiberStack
 * @author Charles
 */
public class TreiberStack2<E> {
    private volatile Node<E> head;

    public void push(E item) {
        Objects.requireNonNull(item);
        Node<E> newHead = new Node<>(item);
        Node<E> oldHead;
        int count = 0;
        do {
            oldHead = head;
            count++;
        } while (!tryPush(oldHead, newHead, count));
        newHead.next = oldHead;
    }

    private boolean tryPush(Node<E> oldHead, Node<E> newHead, int count) {
        boolean isSuccess = UNSAFE.compareAndSwapObject(this, HEAD, oldHead, newHead);
        System.out.println(currentThreadName() + " try push [" + count + "]," +
                " oldHead = " + getValue(oldHead) +
                " newHead = " + getValue(newHead) +
                " isSuccess = " + isSuccess);
        return isSuccess;
    }

    public E pop() {
        Node<E> oldHead;
        Node<E> newHead;
        do {
            oldHead = head;
            System.out.println(currentThreadName() + " do pop:" +
                    " oldHead = " + getValue(oldHead) +
                    " newHead = " + Optional.ofNullable(head).map(s -> s.next.item).orElse(null));
            if (oldHead == null) {
                return null;
            }
            newHead = oldHead.next;
        } while (!tryPop(oldHead, newHead));
        oldHead.next = null;
        return oldHead.item;
    }

    private boolean tryPop(Node<E> oldHead, Node<E> newHead) {
        boolean isSuccess = UNSAFE.compareAndSwapObject(this, HEAD, oldHead, newHead);
        System.out.println(currentThreadName() + " try pop:" +
                " oldHead = " + getValue(oldHead) +
                " currentHead = " + getValue(head) +
                " newHead = " + getValue(newHead) +
                " isSuccess: " + isSuccess);
        return isSuccess;
    }

    private E getValue(Node<E> n) {
        return Optional.ofNullable(n).map(t -> t.item).orElse(null);
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E item) {
            this.item = item;
        }
    }

    // Unsafe mechanics
    private static final Unsafe UNSAFE;
    private static final long HEAD;
    private static final long NEXT;

    static {
        try {
            Field getUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            getUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) getUnsafe.get(null);

            HEAD = UNSAFE.objectFieldOffset(TreiberStack2.class.getDeclaredField("head"));
            NEXT = UNSAFE.objectFieldOffset(Node.class.getDeclaredField("next"));
        } catch (Exception x) {
            throw new Error(x);
        }
    }

    private static class RandomValue {
        private final Integer value;

        public RandomValue() {
            this.value = new Random().nextInt(Integer.MAX_VALUE);
        }

        public Integer getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private static String currentThreadName() {
        return System.nanoTime() + " / " + Thread.currentThread().getName();
    }

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

        TreiberStack2<String> treiberStack2 = new TreiberStack2<>();
        for (int i = 0; i < 10; i++) {
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
                    treiberStack2.push("a");
                    treiberStack2.push("a");
                    treiberStack2.push("a");
                }
            }).start();
        }

        while (true);
    }
}