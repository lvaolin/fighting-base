package com.dhy.designpatterns.composite.printAllEmployee;

public class Main {
   public static void main(String[] args) {
      Leader root = new Leader("John","CEO", 30000);
 
      Leader headSales = new Leader("Robert","Head Sales", 20000);
 
      Leader headMarketing = new Leader("Michel","Head Marketing", 20000);

      Worker clerk1 = new Worker("Laura","Worker Marketing", 10000);
      Worker clerk2 = new Worker("Bob","Worker Marketing", 10000);

      Worker salesExecutive1 = new Worker("Richard","Worker Sales", 10000);
      Worker salesExecutive2 = new Worker("Rob","Worker Sales", 10000);

      root.add(headSales);
      root.add(headMarketing);
 
      headSales.add(salesExecutive1);
      headSales.add(salesExecutive2);
 
      headMarketing.add(clerk1);
      headMarketing.add(clerk2);
 
      //打印该组织的所有员工
      root.print(1);

   }
}