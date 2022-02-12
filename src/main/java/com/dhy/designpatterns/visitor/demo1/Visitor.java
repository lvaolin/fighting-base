package com.dhy.designpatterns.visitor.demo1;

/**
 * 访问者
 */
public class Visitor implements IVisitor {
    //访问普通员工，打印出报表
    @Override
    public void visit(EmployeeCommon commonEmployee) {
        System.out.println(this.getCommonEmployee(commonEmployee));
    }
    //访问部门经理，打印出报表
    @Override
    public void visit(EmployeeManager manager) {
        System.out.println(this.getManagerInfo(manager));
    }
    //员工基本信息
    private String getBasicInfo(Employee employee) {
        String info = "姓名：" + employee.getName() + "\t";
        info = info + "性别：" + (employee.getSex() == Employee.FEMALE ? "女" : "男") + "\t";
        info = info + "薪水：" + employee.getSalary() + "\t";
        return info;
    }

    //组装出部门经理的信息:基本信息+业绩
    private String getManagerInfo(EmployeeManager manager) {
        String basicInfo = this.getBasicInfo(manager);
        String otherInfo = "业绩：" + manager.getPerformance() + "\t";
        return basicInfo + otherInfo;
    }

    //组装出普通员工信息：基本信息+工作职责
    private String getCommonEmployee(EmployeeCommon commonEmployee) {
        String basicInfo = this.getBasicInfo(commonEmployee);
        String otherInfo = "工作：" + commonEmployee.getJob() + "\t";
        return basicInfo + otherInfo;
    }
}