/**
 * @Title package-info
 * @Description
 *
 * 这个例子是要消除  context中的 if else
 * 使之符合开闭原则
 *
 * 1、对demo3的进一步优化，通过SPI模式 来注册所有的策略，完全符合开闭原则
 * 2、通过 isSupport方法的支持，上下文中可以保存所有的策略，不在需要客户端切换策略
 *
 *
 * @Author lvaolin
 * @Date 2022/1/9 11:50
 **/
package com.dhy.designpatterns.StrategyPattern.demo4;