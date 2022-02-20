package com.dhy.designpatterns.StatePattern2.order;

/**
 * @Title OrderStateManager
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 12:21
 **/
public class OrderStateManager extends OrderState {

    public static final OrderState initState = new OrderInitState();
    public static final OrderState submittedState = new OrderSubmittedState();
    public static final OrderState payedState = new OrderPayedState();
    public static final OrderState deliveredState = new OrderDeliveredState();
    public static final OrderState receivedState = new OrderReceivedState();
    public static final OrderState canceledState = new OrderCanceledState();
    public static final OrderState deletedState = new OrderDeletedState();

    //会在上面四种状态中流转
    private OrderState currentState ;

//    {
//        //初始状态
//        currentState = submittedState;
//        currentState.setOrderContext(this);
//    }
    public OrderState getCurrentState() {
        return currentState;
    }
    public void setCurrentState(OrderState currentState) {
        this.currentState = currentState;
        this.currentState.setOrderStateManager(this);
    }
    @Override
    void delete() {
        currentState.delete();
    }
    @Override
    void cancel() {
        currentState.cancel();
    }
    @Override
    void submit() {
        currentState.submit();
    }
    @Override
    void pay() {
        currentState.pay();
    }
    @Override
    void deliver() {
        currentState.deliver();
    }
    @Override
    void receive() {
        currentState.receive();
    }
}
