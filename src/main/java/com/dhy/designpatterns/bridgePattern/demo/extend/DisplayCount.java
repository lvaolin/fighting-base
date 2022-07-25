package com.dhy.designpatterns.bridgePattern.demo.extend;

import com.dhy.designpatterns.bridgePattern.demo.impl.DisplayImpl;

public class DisplayCount extends Display {
    public DisplayCount(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
