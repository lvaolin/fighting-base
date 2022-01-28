package com.dhy.designpatterns.StatePattern2.order;

/**
 * @Title AbstractOrder
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 12:22
 **/
public abstract class AbstractOrder {

    private OrderContext orderContext;

    public OrderContext getOrderContext() {
        return orderContext;
    }

    public void setOrderContext(OrderContext orderContext) {
        this.orderContext = orderContext;
    }

    /**
     * 已提交
     */
    abstract void submitted();

    /**
     * 已支付
     */
    abstract void payed();

    /**
     * 已发货
     */
    abstract void delivered();

    /**
     * 已收货
     */
    abstract void received();



}
