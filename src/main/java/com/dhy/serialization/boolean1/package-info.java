/**
 * @Project fighting-core
 * @Description 为什么不能使用isXXX来定义boolean类型属性
 *
 * JavaBean规范表示：
 * 对于普通类型的属性，要以getXxx()  setXxx() 来定义
 * 对于boolean类型的属性，要以 isXxx()  setXxx() 来定义
 *
 * 当一个bean需要序列化和反序列化时，不同的json库有不同的方法，可能导致不同的结果
 *
 * Gson 是通过 遍历 属性的方式来序列化Bean
 *
 * FastJson和Jackson 是通过 解析 getXxx（），isXxx() 来得到对应的属性名称的
 *
 *
 * @Author lvaolin
 * @Date 2022/6/26 上午10:06
 */
package com.dhy.serialization.boolean1;