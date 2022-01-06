package com.dhy.designpatterns.decorator.demo2;

/**
 * @Project fighting-core
 * @Description QQ告警
 * @Author lvaolin
 * @Date 2022/1/6 上午11:36
 */
public class QqNotifier implements Notifier{
    private Notifier notifier;
    public QqNotifier(){

    }
    public QqNotifier(Notifier notifier){
        this.notifier = notifier;
    }
    @Override
    public void send(String msg) {
        System.out.println("QQ告警发送--"+msg);
        if (notifier!=null) {
            notifier.send(msg);
        }
    }
}
