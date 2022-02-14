package com.dhy.designpatterns.StatePattern2.order;

/**
 * @Title 已提交状态的订单
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 12:27
 **/
public class OrderSubmittedState extends OrderState {
    @Override
    void submit() {
        System.out.println("提交态下不能提交");
    }
    @Override
    void delete() {
        System.out.println("提交态下不能删除");
    }
    @Override
    void cancel() {
        System.out.println("取消成功，由提交态进入到取消态");
        getOrderStateManager().setCurrentState(OrderStateManager.canceledState);
    }
    @Override
    void pay() {
        System.out.println("支付成功，由提交态进入到支付态");
        getOrderStateManager().setCurrentState(OrderStateManager.payedState);
    }
    @Override
    void deliver() {
        System.out.println("提交态下不能发货");
    }
    @Override
    void receive() {
        System.out.println("提交态下不能确认收货");
    }
}
