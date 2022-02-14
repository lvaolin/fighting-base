package com.dhy.designpatterns.facade.demo1;

class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.shutDown(); //只调用一个方法即可，无需了解复杂的关机步骤
    }
}
class Computer{
    public void shutDown(){
        this.saveData();
        this.exitProcess();
        this.powerOff();
    }
    private void saveData(){
        System.out.println("保存数据");
    }
    private void exitProcess(){
        System.out.println("退出进程");
    }
    private void powerOff(){
        System.out.println("断电");
    }
}