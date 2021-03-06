package com.dhy.theadlocal.DhyTaskProxy;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * 代理类：增加了ThreadLocal上绑定的数据中转功能
 */
@Slf4j
public class DhyTaskProxy<V> implements Runnable, Callable {

    private Runnable runnable;
    private Callable<V> callable;
    //----------数据临时中转站-----------
    private Map<String,Object> localData = new HashMap<>();
    private Class threadLocalHolder;


    public DhyTaskProxy(Runnable runnable, Class threadLocalHolder){
        this.runnable = runnable;
        this.threadLocalHolder = threadLocalHolder;
        storeThreadLocal();
    }
    public DhyTaskProxy(Callable callable, Class threadLocalHolder){
        this.callable = callable;
        this.threadLocalHolder = threadLocalHolder;
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



    private void storeThreadLocal() {
        Method[] methods = threadLocalHolder.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                storeField(method);
            }
        }
    }

    private void storeField(Method method) {
        try {
            Object result = method.invoke(null, null);
            localData.put(method.getName(),result);
            log.info(method.getName()+" invoke");
        } catch (Throwable t){
            log.error(t.getMessage(),t);
        }
    }

    private void restoreThreadLocal() {
        Method[] methods = threadLocalHolder.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                restoreField(method);
            }
        }

    }

    private void restoreField(Method method) {
        try {
            Object filedValue = localData.get(method.getName().replaceFirst("s", "g"));
            method.invoke(null, filedValue);
            log.info(method.getName()+" invoke");
        } catch (Throwable t){
            log.error(t.getMessage(),t);
        }
    }

    private void clearThreadLocal() {
        Method[] methods = threadLocalHolder.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("remove")) {
                try {
                    method.invoke(null, null);
                    log.info(method.getName()+" invoke");
                } catch (Throwable t){
                    log.error(t.getMessage(),t);
                }
            }
        }
    }

}


