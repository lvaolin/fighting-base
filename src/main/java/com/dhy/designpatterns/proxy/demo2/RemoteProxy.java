package com.dhy.designpatterns.proxy.demo2;

/**
 * @Project fighting-core
 * @Description 本地服务代理
 * @Author lvaolin
 * @Date 2022/2/10 下午3:45
 */
public class RemoteProxy implements RemoteInterface {
    @Override
    public String m1(String name) {
        //在实例调用之前不会实例化远程对象
        //远程通信、传参
        //接收响应
        return "remote response";
    }
}
