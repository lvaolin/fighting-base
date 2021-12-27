package com.dhy.designpatterns.chainOfResponsibility.interceptor;



/**
 * @Project fighting-core
 * @Description 我的拦截器
 * @Author lvaolin
 * @Date 2021/12/26 下午2:25
 */
public class MyInterceptor2 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("大黄鸭".equals(request.getName())) {
            System.out.println("preHandle登录鉴权成功："+request.getName());
            return true;
        }else{
            System.out.println("preHandle登录鉴权失败："+request.getName());
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle登录鉴权后置处理");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion登录鉴权结束后处理");
    }

}