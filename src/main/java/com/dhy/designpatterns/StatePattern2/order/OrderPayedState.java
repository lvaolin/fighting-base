package com.dhy.designpatterns.StatePattern2.order;

/**
 * @Title OrderSubmittedState
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 12:27
 **/
public class OrderPayedState extends OrderState {
    @Override
    void submit() {
        System.out.println("支付态下不能提交");
    }
    @Override
    void delete() {
        System.out.println("支付态下不能删除");
    }
    @Override
    void cancel() {
        System.out.println("支付态下不能取消");
    }
    @Override
    void pay() {
        System.out.println("支付态下不能支付");
    }
    @Override
    void deliver() {
        System.out.println("已发货，由支付态进入到发货态");
        getOrderStateManager().setCurrentState(OrderStateManager.deliveredState);
    }
    @Override
    void receive() {
        System.out.println("支付态下不能确认收货");
    }
}
