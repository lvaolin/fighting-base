package com.dhy.fanxing.demo9;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project fighting-core
 * @Description
 *   Class<T>  和  Class<?>
 * @Author lvaolin
 * @Date 2022/5/28 下午1:43
 */
public class Demo9 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class clazz  = Dog.class;
        Dog dog1 = (Dog)clazz.newInstance();
        System.out.println(dog1.countLegs());

        Class<Dog> dogClass = Dog.class;
        Dog dog = dogClass.newInstance();
        System.out.println(dog.countLegs());

        Class<?> cla = Dog.class;
        Animal o = (Animal)cla.newInstance();
        System.out.println(o.countLegs());

        //下面是容易出错的例子，证明了 ？ 和不使用 泛型 可能出错， 编译器无法检查出来
        Class clazz2  = Animal.class;
        Dog dog2 = (Dog)clazz2.newInstance();
        System.out.println(dog2.countLegs());

        Class<?> cla2 = Demo9.class;
        Animal o2 = (Animal)cla2.newInstance();
        System.out.println(o2.countLegs());

    }


}
