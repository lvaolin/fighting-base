package com.dhy.designpatterns.command.demo2;

import java.awt.*;

/**
 * 画布
 */
public class DrawCanvas extends Canvas implements Drawable {

    private static final long serialVersionUID = 1972130370393242746L;

    private ReplayCommand history;
    private int radius=8;

    public DrawCanvas(int width,int hieght, ReplayCommand history){
        setSize(width,hieght);
        setBackground(Color.white);
        this.history=history;
    }

    @Override
    public void draw(int x, int y) {
       // Random random = new Random();

        Graphics g = getGraphics();
        g.setColor(Color.MAGENTA);
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("执行一次刷新！"+System.currentTimeMillis());
        history.execute();
    }

}