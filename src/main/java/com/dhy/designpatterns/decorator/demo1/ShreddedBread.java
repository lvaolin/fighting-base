package com.dhy.designpatterns.decorator.demo1;

/**
 * 手抓饼
 */
public class ShreddedBread extends    BaseBread {


    public ShreddedBread(Bread bread){
        setBread(bread);
    }

    /**
     * 得到手抓饼的描述
     * @return
     */
    @Override
    public String getDesc(){
        if (getBread()!=null) {
            return "手抓"+getBread().getDesc();

        }else{
            return "手抓";
        }
    }

    /**
     * 得到手抓饼价格
     * @return
     */
    @Override
    public  int getPrice(){
        if (getBread()!=null) {

            return  5+getBread().getPrice();
        }else{
            return  5;
        }
    }
}
