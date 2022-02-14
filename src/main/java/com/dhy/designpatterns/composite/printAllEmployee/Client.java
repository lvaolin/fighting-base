package com.dhy.designpatterns.composite.printAllEmployee;

/**
 * 打印贵公司所有职员薪资信息
 */
public class Client {
   public static void main(String[] args) {
      Department company = new Department("大黄鸭科技有限公司");
      Department yanfabu = new Department("研发部");
      Department ceshibu = new Department("测试部");
      Worker worker001 = new Worker("王总", 1);
      Worker yan01 = new Worker("研发1",100);
      Worker ce01 = new Worker("测试1",100);
      Worker ce02 = new Worker("测试2",100);

      company.add(worker001);
      company.add(yanfabu);
      company.add(ceshibu);

      yanfabu.add(yan01);
      ceshibu.add(ce01);
      ceshibu.add(ce02);

      //打印该组织的所有员工信息
      company.print(1);

   }
}