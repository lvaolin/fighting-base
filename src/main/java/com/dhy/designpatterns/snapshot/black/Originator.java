package com.dhy.designpatterns.snapshot.black;

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
    public MementoIF createMemento(){
        return new Memento(state);
    }
    /**
     * 从某一个快照 进行恢复 （数据还原）
     * @param memento
     */
    public void restoreMemento(MementoIF memento){
        //需要还原下，这是和白盒的细节区别
        Memento aMemento = (Memento)memento;
        this.state = aMemento.getState();
    }
    
    public String getState(){
        return this.state;
    }
    public void setState(String state){
        this.state = state;
    }


    //对外只公布接口，这样别人就不会获取到内部信息
    private class Memento implements MementoIF{

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
}