package com.dhy.designpatterns.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title Test
 * @Description
 * @Author lvaolin
 * @Date 2021/12/12 22:49
 **/
class User{
    private Date date = new Date();
    private List<String> list = new ArrayList<>();
    public boolean showDownComputer(Computer computer){
        StringBuilder log = new StringBuilder(this.date.toString());
        computer.off();
        return true;
    }
}
class Computer{
    private IPower getPower() { return new Power(); }
    public void off(){
        getPower().off();
    }
}
interface IPower{
    void on();
    void off();
}
class Power implements IPower{
    @Override
    public void on(){}
    @Override
    public void  off(){ }
}