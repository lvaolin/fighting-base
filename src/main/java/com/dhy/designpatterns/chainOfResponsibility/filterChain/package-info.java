/**
 * @Project fighting-core
 * @Description
 *
 * 过滤器链
 *
 * 这是 Tomcat的实现方式
 *
 * 每一个过滤器节点要向下传递请求，否则请求会中断返回
 *
 * 所以 说  doFilter 方法中最后一个参数 FilterChain 非常关键，起到了 "承上启下" 的作用
 *
 * @Author lvaolin
 * @Date 2022/2/10 下午5:09
 */
package com.dhy.designpatterns.chainOfResponsibility.filterChain;