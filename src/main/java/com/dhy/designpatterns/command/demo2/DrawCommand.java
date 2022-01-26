package com.dhy.designpatterns.command.demo2;

import java.awt.Point;


/**
 * 画画命令
 */
public class DrawCommand implements Command {

    private Drawable drawable;
    private Point position;
    public  DrawCommand(Drawable drawable,Point position){
        this.drawable=drawable;
        this.position=position;
    }

    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }

}