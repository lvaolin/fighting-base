/**
 * @Project fighting-core
 * @Description 抽象工厂和工厂方法的区别就在于，工厂方法的工厂仅能生产一种产品，
 *    而抽象工厂的具体工厂可以生成一系列相关的产品：比如统一风格的 播放器、手机、电视、电脑
 *
 *    所以抽象工厂往往用在生产一系列相关产品的场景：比如家具厂生产家具，需要一套同一个风格的家具
 *    桌子、凳子、沙发、衣柜、床等
 * @Author lvaolin
 * @Date 2022/1/17 下午4:58
 */
package com.dhy.designpatterns.abstractFactoryPattern;