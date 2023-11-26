package com.dhy.temp.mem;

public class BaseSon11 extends BaseSon1{
    public String b= "public_11_b";

    public void getPb(){
        System.out.println(super.b);
    }

    public void getPPb(){
        super.getPb();
    }
}
