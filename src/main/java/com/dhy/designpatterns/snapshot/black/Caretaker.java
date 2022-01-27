package com.dhy.designpatterns.snapshot.black;

/**
 * 负责人角色：用来保管 快照
 */
public class Caretaker {

    private MementoIF memento;
    /**
     * 获取快照
     * @return
     */
    public MementoIF retrieveMemento(){
        return this.memento;
    }
    /**
     * 保存快照
     * @param memento
     */
    public void saveMemento(MementoIF memento){
        this.memento = memento;
    }
}