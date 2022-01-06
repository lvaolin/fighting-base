package com.dhy.designpatterns.decorator.demo2;

/**
 * @Project fighting-core
 * @Description 邮件告警
 * @Author lvaolin
 * @Date 2022/1/6 上午11:36
 */
public class MailNotifier implements Notifier{
    private Notifier notifier;
    public MailNotifier(){

    }
    public MailNotifier(Notifier notifier){
        this.notifier = notifier;
    }
    @Override
    public void send(String msg) {
        System.out.println("邮件告警发送--"+msg);
        if (notifier!=null) {
            notifier.send(msg);
        }
    }
}
