package com.dhy.juc.defaultinterfacemethod;

interface Father {

   default void eat(){
       System.out.println("father eat");
   }
   default void sleep(){
       System.out.println("father sleep");
   }

   static void  shopping(){
       System.out.println("father shopping");
   }
}