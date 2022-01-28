package com.dhy.designpatterns.StatePattern2.order;

/**
 * @Title OrderContext
 * @Description
 * @Author lvaolin
 * @Date 2022/1/28 12:21
 **/
public class OrderContext extends AbstractOrder {
    public static final AbstractOrder submittedState = new OrderSubmittedState();
    public static final AbstractOrder payedState = new OrderPayedState();
    public static final AbstractOrder deliveredState = new OrderDeliveredState();
    public static final AbstractOrder receivedState = new OrderReceivedState();

    private AbstractOrder currentState ;

    {
        currentState = submittedState;
        currentState.setOrderContext(this);
    }

    public AbstractOrder getCurrentState() {
        return currentState;
    }

    public void setCurrentState(AbstractOrder currentState) {
        this.currentState = currentState;
        this.currentState.setOrderContext(this);
    }

    @Override
    void submitted() {
        currentState.submitted();
    }

    @Override
    void payed() {
        currentState.payed();
    }

    @Override
    void delivered() {
        currentState.delivered();
    }

    @Override
    void received() {
        currentState.received();
    }
}
