package com.dhy.designpatterns.snapshot.white;

/**
 * 可以理解为 一个带状态的对象的 备份与恢复 过程
 *
 * 这个瞬时快照的保存，实际场景中可能是比较复杂的，介质的存储也比较耗费内存
 *
 * 可以拿  vmware 虚拟机快照来对比，就非常好理解了
 *
 * 还有数据库的事务回滚也是需要快照的
 * 还有git 的代码快照与恢复
 * 还有docker的镜像是一层一层的，也可以看作多个快照的叠加
 * 说白了吧  有备份与恢复需求的场景 都可以用备忘录模式
 *
 * 撤销 操作 是典型的需要 备份与恢复快照的场景，包括各种编辑软件基本上都有这个功能
 *
 */
public class Client {

    //发起人（待备份对象）
    private static Originator o = new Originator();
    //负责人（保管备份介质）
    private static Caretaker c = new Caretaker();


    public static void main(String[] args) {
        System.out.println("白盒测试");
        //改变发起人对象的状态
        o.setState("1");
        //创建备忘录对象，并将发起人对象的状态存储起来
        System.out.println("对象快照："+o.getState());
        c.saveMemento(o.createMemento());
        //修改发起人对象的状态
        o.setState("2");
        System.out.println("最新对象状态："+o.getState());
        //恢复发起人对象的状态
        o.restoreMemento(c.retrieveMemento());
        System.out.println("恢复快照后对象状态："+o.getState());
        
    }
}