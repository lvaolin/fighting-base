package com.dhy.designpatterns.StatePattern2.order;

/**
 * @Title OrderInitState
 * @Description  订单初始状态
 * @Author lvaolin
 * @Date 2022/1/28 12:27
 **/
public class OrderInitState extends OrderState {
    @Override
    void submit() {
        System.out.println("已提交，由初始态进入到提交态");
        getOrderStateManager().setCurrentState(OrderStateManager.submittedState);
    }
    @Override
    void delete() {
        System.out.println("初始态下不能删除");
    }
    @Override
    void cancel() {
        System.out.println("初始态下不能重复取消");
    }
    @Override
    void pay() {
        System.out.println("初始态下不能支付");
    }
    @Override
    void deliver() {
        System.out.println("初始态下不能发货");
    }
    @Override
    void receive() {
        System.out.println("初始态下不能确认收货");
    }
}
