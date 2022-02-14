package com.dhy.designpatterns.StatePattern2.order;

/**
 * @Title 已收货确认态
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 12:27
 **/
public class OrderReceivedState extends OrderState {
    @Override
    void submit() {
        System.out.println("收货确认态下不能提交");
    }
    @Override
    void delete() {
        System.out.println("收货确认态下不能删除");
    }
    @Override
    void cancel() {
        System.out.println("收货确认态下不能取消");
    }
    @Override
    void pay() {
        System.out.println("收货确认态下不能支付");
    }
    @Override
    void deliver() {
        System.out.println("收货确认态下不能发货");
    }
    @Override
    void receive() {
        System.out.println("收货确认态下不能确认收货");
    }
}
