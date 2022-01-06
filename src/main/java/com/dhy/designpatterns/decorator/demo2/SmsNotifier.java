package com.dhy.designpatterns.decorator.demo2;

/**
 * @Project fighting-core
 * @Description 短信告警
 * @Author lvaolin
 * @Date 2022/1/6 上午11:36
 */
public class SmsNotifier implements Notifier{
    private Notifier notifier;
    public SmsNotifier(){

    }
    public SmsNotifier(Notifier notifier){
        this.notifier = notifier;
    }
    @Override
    public void send(String msg) {
        System.out.println("短信告警发送--"+msg);
        if (notifier!=null) {
            notifier.send(msg);
        }
    }
}
