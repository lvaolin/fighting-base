package com.dhy.designpatterns.StatePattern2.order;

import lombok.Data;

/**
 * @Title OrderState
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 12:22
 **/
@Data
public abstract class OrderState {
    private OrderStateManager orderStateManager;
    /**
     * 删除订单
     */
    abstract void delete();
    /**
     * 取消订单
     */
    abstract void cancel();
    /**
     * 提交订单
     */
    abstract void submit();
    /**
     * 支付订单
     */
    abstract void pay();
    /**
     * 发货
     */
    abstract void deliver();
    /**
     * 收货确认
     */
    abstract void receive();
}
