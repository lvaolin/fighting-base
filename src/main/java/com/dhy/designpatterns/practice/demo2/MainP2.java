package com.dhy.designpatterns.practice.demo2;

/**
 * @Project fighting-core
 * @Description 策略模式：

通过组合来实现复用；
设计原则：组合优于继承；
 *
 * @Author lvaolin
 * @Date 2022/2/9 上午10:49
 */
public class MainP2 {
    public static void main(String[] args) {
        ServiceBase serviceBase = new ServiceBase();
        serviceBase.templateMethod(1);
        serviceBase.templateMethod(2);
    }


}
 class ServiceBase{
    //不让子类覆盖这个模板方法
    final void templateMethod(int type){
        m1();
        m2(type);
        m3();
    }

    private void m1(){
        System.out.println("第一步");
    }
    private void m2(int type){
        IM2 im2 = null;
        if (type==1) {
            im2 = new MyService1();
        }
        if (type==2) {
            im2 = new MyService2();
        }
        im2.m2();
    }
    private void m3(){
        System.out.println("第三步");
    }
}

interface IM2{
    void m2();
}
 class MyService1 implements IM2 {
    @Override
    public void m2() {
        System.out.println("MyService1 第二步实现");
    }
}

 class MyService2 implements IM2 {
    @Override
    public void m2() {
        System.out.println("MyService2 第二步实现");
    }
}