package com.dhy.juc.defaultinterfacemethod;

public class Son3 {

    public static void main(String[] args) {

        new Father(){
            @Override
            public void eat() {
                System.out.println("i am eating");
            }
        }.eat();

        new Mather(){
            @Override
            public void eat() {
                System.out.println("mather eating");

            }
        }.eat();

        Father.shopping();
    }
}
