package com.dhy.designpatterns.StatePattern2.order;

/**
 * @Title
 * @Description  已取消状态
 * @Author lvaolin
 * @Date 2022/1/28 12:27
 **/
public class OrderCanceledState extends OrderState {
    @Override
    void submit() {
        System.out.println("取消态下不能提交");
    }
    @Override
    void delete() {
        System.out.println("订单已删除，由取消态转到删除态");
        getOrderStateManager().setCurrentState(OrderStateManager.deletedState);
    }
    @Override
    void cancel() {
        System.out.println("取消态下不能重复取消");
    }
    @Override
    void pay() {
        System.out.println("取消态下不能支付");
    }
    @Override
    void deliver() {
        System.out.println("取消态下不能发货");
    }
    @Override
    void receive() {
        System.out.println("取消态下不能确认收货");
    }
}
