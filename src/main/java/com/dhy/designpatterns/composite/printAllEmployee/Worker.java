package com.dhy.designpatterns.composite.printAllEmployee;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工
 */
@Data
public class Worker implements IComponent{
   private String name;
   private int salary;
   private List<IComponent> subordinates = new ArrayList<>(0);

   public Worker(String name, int sal) {
      this.name = name;
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
         pre +="----";
      }
      System.out.println(pre+"姓名:"+name+",薪资:"+salary);
      for (IComponent subordinate : getSubordinates()) {
         subordinate.print(depth+1);
      }

   }

}