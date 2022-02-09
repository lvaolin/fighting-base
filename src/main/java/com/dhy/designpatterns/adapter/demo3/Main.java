package com.dhy.designpatterns.adapter.demo3;

/**
 * @Project fighting-core
 * @Description 适配器模式实现电压适配器
 *
 * 国内电器普通都是220v的接口
 * 有的国家是110v的接口
 * 如果出差到了国外就需要一个电压适配器来解决问题
 *
 *
 * 这个模式强调的将原来 调用方式、返回值都不合适的接口经过适配器的变换后变得合适了
 *
 * 场景特别明确
 *
 * @Author lvaolin
 * @Date 2022/2/9 上午10:24
 */
public class Main {
    public static void main(String[] args) {
        IV220 v220 = new V220Impl(new V110Impl());
        System.out.println(v220.getV220());
    }
}

/**
 * 你需要的电压接口
 */
interface IV220{
    int getV220();
}

class V220Impl implements IV220{
    private IV110 iv110;
    public V220Impl(IV110 iv110){
        this.iv110 = iv110;
    }
    @Override
    public int getV220() {
        //升压到2倍再输出
        return iv110.getV110()*2;
    }
}

/**
 * 国外的电压接口
 */
interface IV110{
    int getV110();
}

class V110Impl implements IV110{
    @Override
    public int getV110() {
        return 110;
    }
}
