package com.dhy.designpatterns.StatePattern2.order;

/**
 * @Title 已发货状态
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 12:27
 **/
public class OrderDeliveredState extends OrderState {
    @Override
    void submit() {
        System.out.println("发货态下不能提交");
    }
    @Override
    void delete() {
        System.out.println("发货态下不能删除");
    }
    @Override
    void cancel() {
        System.out.println("发货态下不能取消");
    }
    @Override
    void pay() {
        System.out.println("发货态下不能支付");
    }
    @Override
    void deliver() {
        System.out.println("发货态下不能发货");
    }
    @Override
    void receive() {
        System.out.println("确认收货,由发货态进入确认收货态");
        getOrderStateManager().setCurrentState(OrderStateManager.receivedState);
    }
}
