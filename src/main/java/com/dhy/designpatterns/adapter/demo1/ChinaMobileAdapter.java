package com.dhy.designpatterns.adapter.demo1;

/**
 * @Title ChinaMobileAdapter
 * @Description
 * @Author lvaolin
 * @Date 2022/1/9 16:03
 **/
public class ChinaMobileAdapter implements IChinaMobile {

    private IAmericanVoltageService americanVoltageService;

    public ChinaMobileAdapter(IAmericanVoltageService americanVoltageService){
        this.americanVoltageService = americanVoltageService;
    }


    @Override
    public boolean charging220(long v220) {
        int v110 = Integer.parseInt(String.valueOf(v220));
        if (v110!=110) {
            v110 = 110;
        }
        return americanVoltageService.charging110(v110);
    }
}
