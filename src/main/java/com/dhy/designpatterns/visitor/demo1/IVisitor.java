package com.dhy.designpatterns.visitor.demo1;

/**
 * 访问者接口
 */
public interface IVisitor {
    //首先，定义我可以访问普通员工
    public void visit(EmployeeCommon commonEmployee);
    // 其次，定义我还可以访问部门经理
    public void visit(EmployeeManager manager);
}