package com.dhy.robot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class Test {

    private final static int x=38; // x坐标

    private final static int y=38; // y坐标

    private final static int []keys={ // 输入字母
            KeyEvent.VK_J,KeyEvent.VK_A,KeyEvent.VK_V,KeyEvent.VK_A,
            KeyEvent.VK_1,KeyEvent.VK_2,KeyEvent.VK_3,KeyEvent.VK_4,
            KeyEvent.VK_SPACE,
            KeyEvent.VK_N,KeyEvent.VK_I,KeyEvent.VK_U,KeyEvent.VK_B,
            KeyEvent.VK_I,KeyEvent.VK_L,KeyEvent.VK_I,KeyEvent.VK_L,
            KeyEvent.VK_T,KeyEvent.VK_Y
    };


    public static void main(String[] args) throws Exception{
        Robot robot = new Robot(); // new一个机器人

        // 模拟双击打开一个指定位置的文本文件
        robot.mouseMove(38,38); // 模拟移动鼠标到指定位置
        robot.delay(100); // 休息0.1秒
        robot.mousePress(InputEvent.BUTTON1_MASK); // 模拟双击打开文本文件
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(1000); // 休息0.1秒

        // 模拟输入文字
        for(int i=0;i<keys.length;i++){
            robot.keyPress(keys[i]);
            robot.keyRelease(keys[i]);
            robot.delay(100);
        }

        // 模拟保存
        robot.delay(1000); // 休息0.1秒
        robot.keyPress(KeyEvent.VK_CONTROL); // 模拟 ctrl+s
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL); // 模拟释放 ctrl+s
    }
}