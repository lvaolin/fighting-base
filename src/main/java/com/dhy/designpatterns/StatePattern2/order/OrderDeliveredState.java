package com.dhy.designpatterns.StatePattern2.order;

/**
 * @Title OrderSubmittedState
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 12:27
 **/
public class OrderDeliveredState extends AbstractOrder{
    @Override
    void submitted() {

    }

    @Override
    void payed() {

    }

    @Override
    void delivered() {
        System.out.println("订单已发货");
    }

    @Override
    void received() {
        System.out.println("订单已收货");
        super.getOrderContext().setCurrentState(OrderContext.receivedState);
    }
}
