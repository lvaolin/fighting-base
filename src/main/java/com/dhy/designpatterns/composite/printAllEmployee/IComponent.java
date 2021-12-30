package com.dhy.designpatterns.composite.printAllEmployee;

import java.util.List;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2021/12/29 下午7:18
 */
public interface IComponent {
    void add(IComponent e);

    void remove(IComponent e);

    List<IComponent> getSubordinates();

    void print(int depth);
}
