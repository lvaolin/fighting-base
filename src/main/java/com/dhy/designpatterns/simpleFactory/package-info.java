/**
 * @Project fighting-core
 * @Description 简单工厂设计模式，不属于23中设计模式之一
 *
 *  简单工厂和工厂方法的区别在于 工厂没有接口，只有一个实现类工厂
 *  这就要求 根据不同参数来生成不同的产品， 其它和工厂方法一样。
 *  缺点就是 如果要新增产品，需要修改 工厂类代码
 *
 * @Author lvaolin
 * @Date 2022/1/17 下午5:23
 */
package com.dhy.designpatterns.simpleFactory;