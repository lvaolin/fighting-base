package com.dhy.designpatterns.bridgePattern.demo.impl;

public class DisplayImplString3 extends DisplayImpl {
    private String string;
    private int width;
    private int current=0;
    public DisplayImplString3(String string) {
        this.string = string;
        this.width = string.getBytes().length;
    }

    @Override
    public void rawOpen() {
        printLine(current,"");
        current=current+2;
    }

    @Override
    public void rawPrint() {
        printLine(current,string);
        current=current+2;
    }

    @Override
    public void rawClose() {
        printLine(current,string);
    }

    private void printLine(int x,String y) {
        System.out.print("|");

        for (int i = 0; i < x; i++) {
            System.out.print(y);
        }

        System.out.println("-");
    }
}