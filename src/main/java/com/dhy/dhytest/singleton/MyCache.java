package com.dhy.dhytest.singleton;

/**
 * 枚举实现单例模式
 */
public enum MyCache {

    getInstance("k","v");

    private String key;
    private String value;
    private MyCache(String key,String value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyCache{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

class Test{
    public static void main(String[] args) {
        MyCache myCache = MyCache.getInstance;
        System.out.println(myCache.toString());

    }
}
