package com.dhy.designpatterns.decorator.demo2;

/**
 * @Project fighting-core
 * @Description 企业微信告警
 * @Author lvaolin
 * @Date 2022/1/6 上午11:36
 */
public class WeWorkNotifier implements Notifier{
    private Notifier notifier;
    public WeWorkNotifier(){

    }
    public WeWorkNotifier(Notifier notifier){
        this.notifier = notifier;
    }
    @Override
    public void send(String msg) {
        System.out.println("企业微信告警发送--"+msg);
        if (notifier!=null) {
            notifier.send(msg);
        }
    }
}
