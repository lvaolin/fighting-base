/**
 * @Project fighting-core
 * @Description 享元模式、Cache、Flyweight、缓存
 *
 * 其实就是把对象中不变的部分、公共的部分做成单例模式，做成缓存 共用，来达到减少内存占用的目的
 *
 * 本例以游戏中 不同颜色的子弹为例，子弹发出后 有坐标在移动
 * 不同角色发送的子弹颜色不一样，但是尺寸、形状、重量 都是一样的
 * 发射后 坐标不一样 。。
 *
 * 享元模式中将不变的状态称为"内在状态"，改变的状态称为"外在状态"
 *
 * @Author lvaolin
 * @Date 2022/1/17 下午6:44
 */
package com.dhy.designpatterns.flyweight;