package com.dhy.theadlocal.threadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2023/3/9 上午10:07
 */
public class ThreadLocalUtil {
    private static ThreadLocal<Map<String,String>> threadLocal = new ThreadLocal<>();
    public static void set(String key,String value){
        if (threadLocal.get()==null) {
            threadLocal.set(new HashMap());
        }
        threadLocal.get().put(key,value);
    }

    public static String get(String key){
        if (threadLocal.get()==null) {
            threadLocal.set(new HashMap());
        }
        return threadLocal.get().get(key);
    }

    public static void remove(){
        threadLocal.remove();
    }
}
