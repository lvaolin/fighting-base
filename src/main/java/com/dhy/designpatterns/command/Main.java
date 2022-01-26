package com.dhy.designpatterns.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;


public class Main extends JFrame implements ActionListener,MouseMotionListener,WindowListener{

    /**
     * 重放命令实现：保存绘制历史过程
     */
    private ReplayCommand history=new ReplayCommand() ;

    /**
     * 清楚按钮
     */
    private JButton btnClear=new JButton("清除");
    /**
     * 撤销
     */
    private JButton btnUndo=new JButton("撤销");
    /**
     * 重放按钮
     */
    private JButton btnRePaint=new JButton("重放");

    /**
     * 画布
     */
    private DrawCanvas canvas=new DrawCanvas(400,400,history);

    public Main(String title){
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        btnClear.addActionListener(this);
        btnRePaint.addActionListener(this);
        btnUndo.addActionListener(this);

        Box btnBox=new Box(BoxLayout.X_AXIS);
        btnBox.add(btnClear);
        btnBox.add(btnRePaint);
        btnBox.add(btnUndo);

        Box mainBox=new Box(BoxLayout.Y_AXIS);
        mainBox.add(btnBox);
        mainBox.add(canvas);

        getContentPane().add(mainBox);

        pack();
        show();
    }

    public static void main(String[] args) {

        new Main("命令模式");

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnClear){
            //清除
            history.clear();
            canvas.repaint();
        }
        if(e.getSource()==btnRePaint){
            //重画
            history.execute();
            canvas.repaint();
        }
        if(e.getSource()==btnUndo){
            //撤销
            history.undo();
            history.execute();
            canvas.repaint();
        }
    }


    /**
     * 鼠标拖拽事件
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        //准备绘制命令
        Command cmd=new DrawCommand(canvas,e.getPoint());
        //记录绘制历史，便于重放
        history.append(cmd);
        //执行绘制命令
        cmd.execute();
    }


    /**
     * 关闭窗口
     * @param e
     */
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }




    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}