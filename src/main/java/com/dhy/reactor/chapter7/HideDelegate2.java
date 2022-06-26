package com.dhy.reactor.chapter7;

/**
 * @Project fighting-core
 * @Description 查询 某位员工所在部门的部门经理（中介者模式）
 * @Author lvaolin
 * @Date 2022/6/26 下午5:46
 */
public class HideDelegate2 {


    public static void main(String[] args) {

        //初始化
        Person zhansan = new Person("张三");//员工张三
        Person zhansanManager = new Person("李四");//张三的经理
        Department department = new Department(zhansanManager);
        zhansan.setDepartment(department);

        //张三在这里就是中介者
        String managerName = zhansan.getManagerName();
        System.out.println("张三的经理是："+managerName);
    }

    //员工类
    static class Person {
        private String name;//姓名
        private Department department;//所属部门

        public Person(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        /**
         * 这个叫委托函数
         * @return
         */
        public String getManagerName(){
            return this.department.getManager().getName();
        }
    }

    //部门类
    static class Department {
        private Person manager;//部门经理

        public Department(Person manager) {
            this.manager = manager;

        }

        public Person getManager() {
            return manager;
        }
    }
}
