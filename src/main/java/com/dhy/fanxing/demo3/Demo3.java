package com.dhy.fanxing.demo3;

/**
 * @Project fighting-core
 * @Description 泛型用在静态方法上
 * @Author lvaolin
 * @Date 2022/3/30 上午12:22
 */
public class Demo3 {
    public static void main(String[] args) {
        Hello.sayHello1(new Integer(1));
        Hello.sayHello2(new Long(2));
        Hello.sayHello3(new String("sssss"));
        Hello.sayHello4(new Float(1.0f),new Double(2.0d));

    }
}

class Hello{
    //每个方法自己要声明下 <T>
    public static  <T> void  sayHello1(T t){
        System.out.println(t.getClass().getCanonicalName());
    }

    public static <R> void  sayHello2(R r){
        System.out.println(r.getClass().getCanonicalName());
    }

    public static <Z> Z  sayHello3(Z z){
        System.out.println(z.getClass().getCanonicalName());
        return z;
    }
    //尖括号里的仅是用来声明用，告诉编译器，这是一个泛型类型
    public static <X,Y> Y  sayHello4(X x,Y y){
        System.out.println(x.getClass().getCanonicalName());
        return y;
    }

}