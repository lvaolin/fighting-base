package com.dhy.designpatterns.decorator.demo1;


/**
 * 饼
 */
public interface  Bread {

    /**
     * 得到饼的配料
     * @return
     */
     String getDesc();

    /**
     * 得到饼价格
     * @return
     */
      int getPrice();
}
