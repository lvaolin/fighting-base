package com.dhy.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Project fighting-core
 * @Description 公众号：老吕架构
 * 问题：有三个HTTP API,
 * 分别是 http://example.com/first_part, http://example.com/second_part, http://example.com/third_part, 请求方法为GET。
 * 要求并发获取三个API结果，
 * 结果拼接成一个字符串，顺序必须为 first_part_result + second_part_result + third_part_result。
 *
 * @Author lvaolin
 * @Date 2021/5/31 3:24 下午
 */
public class CompletableFutureDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            //http request
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("http1 response");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "http1";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            //http request
            System.out.println("http2 response");
            return "http2";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            //http request
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("http3 response");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "http3";
        });
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(future1, future2, future3);
        String result = future1.get()+future2.get()+future3.get();
        System.out.println("result:"+result);
    }
}
