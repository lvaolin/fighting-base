package com.dhy.designpatterns.chainOfResponsibility.interceptor;

/**
 * @Project fighting-core
 * @Description 上下文模拟
 * @Author lvaolin
 * @Date 2021/12/26 下午2:28
 */
public class Main {

    public static void main(String[] args) {

        HttpServletRequest httpServletRequest = new HttpServletRequest();
        HttpServletResponse httpServletResponse = new HttpServletResponse();

        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        //拦截验证成功的例子
        try {
            httpServletRequest.setName("大黄鸭");
            dispatcherServlet.doDispatch(httpServletRequest,httpServletResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------------------------");

        //拦截验证失败的例子
        try {
            httpServletRequest.setName("派大星");
            dispatcherServlet.doDispatch(httpServletRequest,httpServletResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
