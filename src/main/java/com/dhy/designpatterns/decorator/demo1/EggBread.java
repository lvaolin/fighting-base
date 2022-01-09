package com.dhy.designpatterns.decorator.demo1;

/**
 * 鸡蛋饼
 */
public class EggBread extends BaseBread {

    public EggBread(Bread bread){
        setBread(bread);
    }
    @Override
    public String getDesc() {
        if (getBread()!=null) {
            return "鸡蛋"+getBread().getDesc();
        }else{
            return "鸡蛋";
        }

    }

    @Override
    public int getPrice() {
        if (getBread()!=null) {

            return 2+getBread().getPrice();
        }else {
            return 2;
        }
    }
}
