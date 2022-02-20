package com.dhy.designpatterns.StatePattern2.order;

/**
 * @Title
 * @Description  已删除状态
 * @Author lvaolin
 * @Date 2022/1/28 12:27
 **/
public class OrderDeletedState extends OrderState {
    @Override
    void submit() {
        System.out.println("删除态下不能提交");
    }
    @Override
    void delete() {
        System.out.println("删除态下不能删除");
    }
    @Override
    void cancel() {
        System.out.println("删除态下不能取消");
    }
    @Override
    void pay() {
        System.out.println("删除态下不能支付");
    }
    @Override
    void deliver() {
        System.out.println("删除态下不能发货");
    }
    @Override
    void receive() {
        System.out.println("删除态下不能确认收货");
    }
}
