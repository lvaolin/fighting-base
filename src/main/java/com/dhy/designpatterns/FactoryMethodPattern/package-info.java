/**
 * @Project fighting-core
 * @Description 工厂方法模式
 *
 * 特点：
 *
 * 产品有接口
 * 工厂有接口
 *
 * 每一种产品都有自己的工厂实现类
 *
 * 每个工厂实现类只负责特定产品的生产
 *
 * Dubbo源码应用：
 * CacheFactory+Cache 接口
 *  MetadataReportFactory + MetadataReport 接口
 *  RouterFactory + Router 接口
 *  等等很多
 *
 * @Author lvaolin
 * @Date 2022/1/17 下午3:18
 */
package com.dhy.designpatterns.FactoryMethodPattern;