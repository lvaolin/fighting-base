package com.dhy.juc.functionalinterface;

@FunctionalInterface
public interface MyFunInterface2<T,R> {
    R print(T msg);
}

class MyFunInterface2test{
    static int x = 1;
    public static void main(String[] args) {
        //从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量
        //为什么：为了多线程情况下函数的安全性，x在多线程情况下不断变化就会给函数带来不确定性，
        // 也就是函数不安全了。
        //而函数式编程的一个好处是为了 消除 变量，从而确保多线程的安全。
        //所以就要求 函数体内的变量要么是 final类型的，要不虽然没有声明，但事实上是不变的
        //只有这样才能保证函数的线程安全性

        //x = 2;
        //字符串转数值类型
        MyFunInterface2<String,Integer> f2 = (n)->{
            return Integer.parseInt(n)+x;
        };

        System.out.println(f2.print("100"));

    }
}
