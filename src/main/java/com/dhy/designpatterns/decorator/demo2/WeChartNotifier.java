package com.dhy.designpatterns.decorator.demo2;

/**
 * @Project fighting-core
 * @Description 微信告警
 * @Author lvaolin
 * @Date 2022/1/6 上午11:36
 */
public class WeChartNotifier implements Notifier{
    private Notifier notifier;
    public WeChartNotifier(){

    }
    public WeChartNotifier(Notifier notifier){
        this.notifier = notifier;
    }
    @Override
    public void send(String msg) {
        System.out.println("微信告警发送--"+msg);
        if (notifier!=null) {
            notifier.send(msg);
        }
    }
}
