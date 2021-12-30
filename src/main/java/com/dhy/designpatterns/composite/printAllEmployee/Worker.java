package com.dhy.designpatterns.composite.printAllEmployee;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Worker implements IComponent{
   private String name;
   private String dept;
   private int salary;
   private List<IComponent> subordinates = new ArrayList<>(0);

   //构造函数
   public Worker(String name, String dept, int sal) {
      this.name = name;
      this.dept = dept;
      this.salary = sal;
   }

   @Override
   public void add(IComponent e) {
   }

   @Override
   public void remove(IComponent e) {
   }

   @Override
   public List<IComponent> getSubordinates(){
     return subordinates;
   }

   @Override
   public void print(int depth){
      String pre = "";
      for(int i=0; i<depth; i++) {
         pre +="-";
      }
      System.out.println(pre+":"+name+","+dept+","+salary);
      for (IComponent subordinate : subordinates) {
         subordinate.print(depth+1);
      }

   }

}