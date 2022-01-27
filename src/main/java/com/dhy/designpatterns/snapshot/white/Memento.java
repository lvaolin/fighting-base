package com.dhy.designpatterns.snapshot.white;

/**
 *  快照对象，备忘录对象，记录了某个对象的一个瞬时状态
 */
public class Memento {

    private String state;
    
    public Memento(String state){
        this.state = state;
    }
    
    public String getState(){
        return this.state;
    }
    public void setState(String state){
        this.state = state;
    }
}