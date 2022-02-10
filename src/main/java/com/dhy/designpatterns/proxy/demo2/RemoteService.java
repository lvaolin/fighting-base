package com.dhy.designpatterns.proxy.demo2;

/**
 * @Project fighting-core
 * @Description 远程服务提供者
 * @Author lvaolin
 * @Date 2022/2/10 下午3:46
 */
public class RemoteService implements RemoteInterface {
    @Override
    public String m1(String name) {
        return "hello"+name;
    }
}
