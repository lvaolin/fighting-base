package com.dhy.designpatterns.chainOfResponsibility;


import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @Title TomcatFilterChainTest
 * @Description
 * @Author lvaolin
 * @Date 2021/12/26 12:54
 **/
public class Main {
    public static void main(String[] args) throws IOException, ServletException {
        //准备过滤器链
        ApplicationFilterChain filterChain = new ApplicationFilterChain();
        //设置目标servlet
        filterChain.setServlet(new MyServlet());
        //设置过滤器集合
        filterChain.addFilter(new Filter1());
        filterChain.addFilter(new Filter2());
        filterChain.addFilter(new Filter3());
        filterChain.addFilter(new FilterResponseTime());
        //过滤请求
        System.out.println("-----request 开始----");
        filterChain.doFilter(null, null);
    }

}
