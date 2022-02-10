package com.dhy.designpatterns.proxy.demo1;

/**
 * @Title Proxy
 * @Description
 *
 *     强调了 代理对目标方法的控制，包括接口性能监控，接口权限，调用日志，限流，熔断，降级等
 *
 * @Author lvaolin
 * @Date 2022/1/28 18:56
 **/
public class Proxy implements ServiceIF{
    private ServiceIF targetService;
    public Proxy(ServiceIF serviceIF){
        this.targetService = serviceIF;
    }
    @Override
    public String method1() {
        System.out.println(targetService.getClass().getCanonicalName()+"被调用");
        long beginTime = System.currentTimeMillis();
        String result = targetService.method1();
        System.out.println("接口耗时："+(System.currentTimeMillis() - beginTime));
        return result;
    }
}
