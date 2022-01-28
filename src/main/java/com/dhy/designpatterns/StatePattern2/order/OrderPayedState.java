package com.dhy.designpatterns.StatePattern2.order;

/**
 * @Title OrderSubmittedState
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 12:27
 **/
public class OrderPayedState extends AbstractOrder{
    @Override
    void submitted() {

    }

    @Override
    void payed() {
        System.out.println("订单已支付");
    }

    @Override
    void delivered() {
        System.out.println("订单已发货");
        super.getOrderContext().setCurrentState(OrderContext.deliveredState);
    }

    @Override
    void received() {

    }
}
