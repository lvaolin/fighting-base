package com.dhy.designpatterns.othersPattern.gugong;

/**
 * @Project fighting-core
 * @Description 雇工模式 测试
 * @Author lvaolin
 * @Date 2022/2/10 下午2:24
 */
public class Client {
    public static void main(String[] args) {
        Cleaner cleaner = new Cleaner();
        cleaner.clean(new Garden());
        cleaner.clean(new Kitchen());
        cleaner.clean(new Cloth());
        //这和策略模式有啥区别？？？

    }
}
