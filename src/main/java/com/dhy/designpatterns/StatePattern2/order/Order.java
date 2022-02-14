package com.dhy.designpatterns.StatePattern2.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Project fighting-core
 * @Description 订单
 * @Author lvaolin
 * @Date 2022/2/14 下午3:19
 */
@Data
public class Order {
    private String orderId;
    private Date createTime;
    private BigDecimal aggregateAmount;
    private String payType;
    private List<String> details = new ArrayList<String>();
    private OrderStateManager orderStateManager;
}
