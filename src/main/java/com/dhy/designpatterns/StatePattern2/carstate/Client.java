package com.dhy.designpatterns.StatePattern2.carstate;

public class Client {

    public static void main(String[] args) {
        CarContext carContext = new CarContext();//初始状态是停车关门状态
        carContext.open();
        carContext.close();
        carContext.running();
        carContext.stop();
        carContext.running();
        carContext.open();


    }
}
