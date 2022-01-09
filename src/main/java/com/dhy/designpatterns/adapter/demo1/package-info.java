/**
 * @Title package-info
 * @Description\
 *
 * 适配器 是一种结构性设计模式，它能使接口不兼容的对象相互合作
 * 它强调的是 调用与被调用 双方都已经存在完整的成熟的接口，但是接口不兼容，
 * 所以必须做下适配使接口兼容起来，这需要一个适配器来连接不兼容的双方
 *
 * 举个例子：
 *
 * 中国充电接口是220付，美国充电接口是110付
 *
 * 中国人到了美国 手机、电脑 等是无法直接充电的，必须要有 电源适配器 才行
 *
 * User用户，chinaMobile中国手机， VoltageAdapter电压适配器， AmericanVoltage 美国电压
 *
 * @Author lvaolin
 * @Date 2022/1/9 15:46
 **/
package com.dhy.designpatterns.adapter.demo1;