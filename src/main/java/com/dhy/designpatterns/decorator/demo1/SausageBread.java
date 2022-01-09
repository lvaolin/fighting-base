package com.dhy.designpatterns.decorator.demo1;

/**
 * 香肠饼
 */
public class SausageBread extends BaseBread {

    SausageBread(Bread bread) {
        super.setBread(bread);
    }

    @Override
    public String getDesc() {
        if (getBread()!=null) {
            return "香肠"+getBread().getDesc();
        }else{
            return "香肠";
        }

    }

    @Override
    public int getPrice() {
        if (getBread()!=null) {
            return 3+getBread().getPrice();
        }else{
            return 3;
        }

    }
}
