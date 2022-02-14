package com.dhy.designpatterns.composite.printAllEmployee;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Department implements IComponent{
   private String departmentName;
   private List<IComponent> subordinates;
 
   //构造函数
   public Department(String departmentName) {
      this.departmentName = departmentName;
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
         pre +="----";
      }
      System.out.println(pre+"部门名称:"+departmentName);
      for (IComponent subordinate : getSubordinates()) {
         subordinate.print(depth+1);
      }

   }

}