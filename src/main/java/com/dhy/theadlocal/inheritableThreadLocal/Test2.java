package com.dhy.theadlocal.inheritableThreadLocal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Project fighting-core
 * @Description 手撕一个ThreadLocalUtil工具类，解决线程池场景下  父子线程之间数据传递问题
 * @Author lvaolin
 * @Date 2022/4/26 上午11:25
 */
public class Test2 {
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
        ThreadLocalUtil.setUserId("1001");
        ThreadLocalUtil.setTraceId("o98iuj76yhe3");

        //复用核心线程，未使用代理
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("未使用代理："+ThreadLocalUtil.getUserId());
                System.out.println("未使用代理："+ThreadLocalUtil.getTraceId());
            }
        });

        //复用核心线程，Runnable使用代理
        executorService.submit((Runnable) new TaskProxy(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用代理Runnable："+ThreadLocalUtil.getUserId());
                System.out.println("使用代理Runnable："+ThreadLocalUtil.getTraceId());
            }
        }));

        //复用核心线程，Callable使用代理
        executorService.submit((Callable) new TaskProxy<String>(new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println("使用代理Callable："+ThreadLocalUtil.getUserId());
                System.out.println("使用代理Callable："+ThreadLocalUtil.getTraceId());
                return "ok";
            }
        }));
        System.out.println("over");
        while (true);
    }
}

/**
 * 代理类：增加ThreadLocal数据传递功能
 *
 */
class TaskProxy<V> implements Runnable, Callable {

    private Runnable runnable;
    private Callable<V> callable;

    public TaskProxy(Runnable runnable){
        this.runnable = runnable;
        storeThreadLocal();
    }
    public TaskProxy(Callable callable){
        this.callable = callable;
        storeThreadLocal();
    }

    @Override
    public void run() {
        restoreThreadLocal();
        this.runnable.run();
        clearThreadLocal();
    }

    @Override
    public Object call() throws Exception {
        restoreThreadLocal();
        V v = this.callable.call();
        clearThreadLocal();
        return v;
    }


    //------------------------绑定的数据-----------
    private String userId;
    private String traceId;
    private void storeThreadLocal() {
        this.userId = ThreadLocalUtil.getUserId();
        this.traceId = ThreadLocalUtil.getTraceId();
    }
    private void restoreThreadLocal() {
        ThreadLocalUtil.setUserId(userId);
        ThreadLocalUtil.setTraceId(traceId);
    }
    private void clearThreadLocal() {
        ThreadLocalUtil.removeUserId();
        ThreadLocalUtil.removeTraceId();
    }

}

/**
 * ThreadLocal工具类
 */
class ThreadLocalUtil{

    //可以使用一个自定义 上下文DTO 来存储数据，就不需要写多个ThreadLocal了
    private static ThreadLocal<String> userIdThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> traceIdThreadLocal = new ThreadLocal<>();
    public static void setUserId(String userId){
        userIdThreadLocal.set(userId);
    }
    public static void setTraceId(String traceId){
        traceIdThreadLocal.set(traceId);
    }

    public static String getUserId(){
        return userIdThreadLocal.get();
    }
    public static String getTraceId(){
        return traceIdThreadLocal.get();
    }

    public static void removeUserId(){
        userIdThreadLocal.remove();
    }

    public static void removeTraceId(){
        traceIdThreadLocal.remove();
    }
}
