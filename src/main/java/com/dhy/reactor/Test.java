package com.dhy.reactor;

/**
 * @Project fighting-core
 * @Description 参数使用final修饰的好处
 * @Author lvaolin
 * @Date 2022/7/3 上午10:35
 */
public interface Test {
    void method1(final int a,final boolean b,final String c,final Object d);
}
class TestImpl implements Test{

    @Override
    public void method1(final int a,final boolean b,final String c,final Object d) {
//        a = 2;
//        b = false;
//        c = "";
//        d = null;
    }
}