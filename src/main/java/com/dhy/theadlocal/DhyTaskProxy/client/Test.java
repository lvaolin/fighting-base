package com.dhy.theadlocal.DhyTaskProxy.client;

import com.dhy.theadlocal.DhyTaskProxy.DhyTaskProxy;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Project fighting-core
 * @Description 手撕一个ThreadLocalUtil工具类，解决线程池场景下  父子线程之间数据传递问题
 * @Author lvaolin
 * @Date 2022/4/26 上午11:25
 */
public class Test {
    static ExecutorService executorService = Executors.newFixedThreadPool(1);
    static {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("预热，产生核心线程");
            }
        });
    }
    public static void main(String[] args) {
        //-----主线程绑定数据----
        ThreadLocalHolder.setUserId("1001");
        ThreadLocalHolder.setTraceId("o98iuj76yhe3");
        RequestContext appContext = new RequestContext();
        appContext.setSessionId("dfaegerge45h4w5ehth");
        appContext.setDbKey("db1000");
        ThreadLocalHolder.setAppContext(appContext);

        //复用核心线程，未使用代理
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("未使用代理："+ ThreadLocalHolder.getUserId());
                System.out.println("未使用代理："+ ThreadLocalHolder.getTraceId());
                System.out.println("未使用代理："+ ThreadLocalHolder.getAppContext());
            }
        });

        //复用核心线程，Runnable使用代理
        executorService.submit((Runnable) new DhyTaskProxy(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用代理Runnable："+ ThreadLocalHolder.getUserId());
                System.out.println("使用代理Runnable："+ ThreadLocalHolder.getTraceId());
                System.out.println("使用代理Runnable："+ ThreadLocalHolder.getAppContext());
            }
        }, ThreadLocalHolder.class));

        //复用核心线程，Callable使用代理
        executorService.submit((Callable) new DhyTaskProxy<String>(new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println("使用代理Callable："+ ThreadLocalHolder.getUserId());
                System.out.println("使用代理Callable："+ ThreadLocalHolder.getTraceId());
                System.out.println("使用代理Callable："+ ThreadLocalHolder.getAppContext());
                return "ok";
            }
        }, ThreadLocalHolder.class));


        new Thread(new DhyTaskProxy(new Runnable() {
            @Override
            public void run() {
                System.out.println("new Thread,使用代理Runnable："+ ThreadLocalHolder.getUserId());
            }
        },ThreadLocalHolder.class)).start();

        System.out.println("over");
        while (true);
    }
}


