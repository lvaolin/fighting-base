package com.dhy.designpatterns.bridgePattern.demo;

import com.dhy.designpatterns.bridgePattern.demo.extend.Display;
import com.dhy.designpatterns.bridgePattern.demo.extend.DisplayCount;
import com.dhy.designpatterns.bridgePattern.demo.impl.DisplayImplString;
import com.dhy.designpatterns.bridgePattern.demo.impl.DisplayImplString2;
import com.dhy.designpatterns.bridgePattern.demo.impl.DisplayImplString3;

public class Main {
    public static void main(String[] args){
        Display d1 = new Display(new DisplayImplString("hello world 1"));
        DisplayCount d2 = new DisplayCount(new DisplayImplString("hello world 2"));

        DisplayCount d3 = new DisplayCount(new DisplayImplString2("*"));

        DisplayCount d4 = new DisplayCount(new DisplayImplString3("#"));


        d1.display();
        d2.display();
        d2.multiDisplay(5);
        d3.multiDisplay(5);
        d4.multiDisplay(5);
    }

}