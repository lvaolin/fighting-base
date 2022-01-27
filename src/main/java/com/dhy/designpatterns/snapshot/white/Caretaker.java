package com.dhy.designpatterns.snapshot.white;

/**
 * 负责人角色：用来保管 快照
 */
public class Caretaker {

    private Memento memento;
    /**
     * 获取快照
     * @return
     */
    public Memento retrieveMemento(){
        return this.memento;
    }
    /**
     * 保存快照
     * @param memento
     */
    public void saveMemento(Memento memento){
        this.memento = memento;
    }
}