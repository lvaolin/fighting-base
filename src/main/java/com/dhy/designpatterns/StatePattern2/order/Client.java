package com.dhy.designpatterns.StatePattern2.order;


/**
 * @Title Client
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 12:35
 **/
public class Client {

    public static void main(String[] args) {
        OrderContext orderContext = new OrderContext();
        //orderContext.submitted();
        orderContext.payed();
        orderContext.delivered();
        orderContext.received();
    }
}
