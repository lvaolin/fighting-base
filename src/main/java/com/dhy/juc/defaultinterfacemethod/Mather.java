package com.dhy.juc.defaultinterfacemethod;

public interface Mather {

    default void eat(){
        System.out.println("mather eat");
    }
}
