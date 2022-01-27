package com.dhy.designpatterns.snapshot.multiSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 负责人角色：用来保管 快照
 */
public class Caretaker {

    //使用栈结构保存多个快照
    private Stack<Memento> mementos = new Stack<>();
    /**
     * 获取快照
     * @return
     */
    public Memento retrieveMemento(){
        return this.mementos.pop();
    }
    /**
     * 保存快照
     * @param memento
     */
    public void saveMemento(Memento memento){
        this.mementos.push(memento);
    }
}