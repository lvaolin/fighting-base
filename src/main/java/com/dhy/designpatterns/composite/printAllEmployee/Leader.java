package com.dhy.designpatterns.composite.printAllEmployee;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Leader implements IComponent{
   private String name;
   private String dept;
   private int salary;
   private List<IComponent> subordinates;
 
   //构造函数
   public Leader(String name, String dept, int sal) {
      this.name = name;
      this.dept = dept;
      this.salary = sal;
      subordinates = new ArrayList<IComponent>();
   }

   @Override
   public void add(IComponent e) {
      subordinates.add(e);
   }

   @Override
   public void remove(IComponent e) {
      subordinates.remove(e);
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