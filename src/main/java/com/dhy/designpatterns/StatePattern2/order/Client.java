package com.dhy.designpatterns.StatePattern2.order;


import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title Client1
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 12:35
 **/
public class Client {

    public static void main(String[] args) {
        //订单状态上下文，初始状态
        OrderStateManager orderStateManager = new OrderStateManager();
        orderStateManager.setCurrentState(OrderStateManager.initState);

        //订单信息
        Order order = new Order();
        order.setOrderId("202202020001");
        order.setCreateTime(new Date());
        order.setPayType("在线支付");
        order.setAggregateAmount(new BigDecimal(100));
        //给这个订单一个状态管理器
        order.setOrderStateManager(orderStateManager);

        //订单进行提交操作
        orderStateManager.submit();
        orderStateManager.cancel();
        orderStateManager.pay();
        orderStateManager.deliver();
        orderStateManager.receive();
        orderStateManager.cancel();
        orderStateManager.delete();

    }
}
