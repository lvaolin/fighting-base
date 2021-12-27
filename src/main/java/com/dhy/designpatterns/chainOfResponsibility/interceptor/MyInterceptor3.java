package com.dhy.designpatterns.chainOfResponsibility.interceptor;


/**
 * @Project fighting-core
 * @Description 我的拦截器
 * @Author lvaolin
 * @Date 2021/12/26 下午2:25
 */
public class MyInterceptor3 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle购买验证");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle购买验证后置处理");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion购买验证结束后处理");
    }

}