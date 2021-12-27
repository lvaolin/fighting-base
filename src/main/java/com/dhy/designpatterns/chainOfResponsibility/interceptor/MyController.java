package com.dhy.designpatterns.chainOfResponsibility.interceptor;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Project fighting-core
 * @Description 模拟Spring Controller
 * @Author lvaolin
 * @Date 2021/12/26 下午2:25
 */
public class MyController {

    @RequestMapping("/hello")
    String hello(String name){
        System.out.println("-业务处理开始-");
        System.out.println("-业务处理结束-");
        return "hello "+name;
    }
}
