package com.dhy.designpatterns.StatePattern2.order;

/**
 * @Title OrderSubmittedState
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 12:27
 **/
public class OrderSubmittedState extends AbstractOrder{
    @Override
    void submitted() {
        System.out.println("订单已提交");
        super.getOrderContext().setCurrentState(OrderContext.submittedState);
    }

    @Override
    void payed() {
        System.out.println("订单已支付");
        super.getOrderContext().setCurrentState(OrderContext.payedState);
    }

    @Override
    void delivered() {
        System.out.println("未支付不能发货");
    }

    @Override
    void received() {

    }
}
