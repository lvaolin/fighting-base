package com.dhy.designpatterns.snapshot.white;

/**
 * 发起人角色：创建快照（备忘录）对象； 恢复快照（备忘录）对象；
 *
 */
public class Originator {

    private String state;
    /**
     * 创建一个瞬时快照对象（数据备份）
     * @return
     */
    public Memento createMemento(){
        return new Memento(state);
    }
    /**
     * 从某一个快照 进行恢复 （数据还原）
     * @param memento
     */
    public void restoreMemento(Memento memento){
        this.state = memento.getState();
    }
    
    public String getState(){
        return this.state;
    }
    public void setState(String state){
        this.state = state;
    }
}