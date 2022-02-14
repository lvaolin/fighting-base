package com.dhy.designpatterns.decorator.demo2;

/**
 * @Project fighting-core
 * @Description 监控告警
 * @Author lvaolin
 * @Date 2022/1/6 上午11:41
 */
public class Client {
    public static void main(String[] args) {

        //你想要一个只发邮件的告警器
        System.out.println("----------只发邮件的告警器---------");
        Notifier mailNotifier = new MailNotifier();
        mailNotifier.send("cpu 99% 了");

        //我想要一个同时发送邮件和短信的告警器
        System.out.println("----------同时发送邮件和短信的告警器----------");
        Notifier smsNotifier = new SmsNotifier(mailNotifier);
        smsNotifier.send("内存爆了");

        //他想要一个同时按短信、邮件、企业微信、个人微信、QQ 顺序依次报警的告警器
        System.out.println("----------同时按短信、邮件、企业微信、个人微信、QQ 顺序依次报警的告警器----");
        Notifier heQq = new QqNotifier();
        Notifier heWcNotifier = new WeChartNotifier(heQq);
        Notifier heWwNotifier = new WeWorkNotifier(heWcNotifier);
        Notifier heMailNotifier = new MailNotifier(heWwNotifier);
        Notifier heSmsNotifier = new SmsNotifier(heMailNotifier);
        heSmsNotifier.send("硬盘爆了");
    }
}
