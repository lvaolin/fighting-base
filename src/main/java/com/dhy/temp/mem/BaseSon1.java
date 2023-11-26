package com.dhy.temp.mem;

public class BaseSon1 extends Base{
    private String a = "private_A_a";
    public String b= "public_A_b";
    public void getPb(){
        System.out.println(super.b);
    }
}
