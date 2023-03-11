package com.dhy.theadlocal.threadLocal;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2023/3/9 上午10:14
 */
public class Client3 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalUtil.set("name","zhangsan1");
                ThreadLocalUtil.get("name");
                ThreadLocalUtil.remove();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalUtil.set("name","zhangsan2");
                ThreadLocalUtil.get("name");
                ThreadLocalUtil.remove();
            }
        }).start();

    }
}
