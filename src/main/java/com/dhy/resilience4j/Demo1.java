package com.dhy.resilience4j;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.bulkhead.ThreadPoolBulkhead;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.retry.Retry;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Title Demo1
 * @Description
 * @Author lvaolin
 * @Date 2022/3/8 22:49
 **/
public class Demo1 {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> Demo1.sayHelloWorld("dhy");

        Decorators.DecorateSupplier<String> supplier1 = Decorators.ofSupplier(supplier)
                //舱壁模式限流，信号量实现的
                .withBulkhead(Bulkhead.ofDefaults("name"))
                //熔断器，状态机 实现的
                .withCircuitBreaker(CircuitBreaker.ofDefaults("name"))
                //重试器
                .withRetry(Retry.ofDefaults("name"))
                //限速器
                .withRateLimiter(RateLimiter.ofDefaults("name"))
                //线程池隔离
             //   .withThreadPoolBulkhead(ThreadPoolBulkhead.ofDefaults("name"))
                //降级处理
                .withFallback(asList(CallNotPermittedException.class, BulkheadFullException.class)
                        , throwable -> "Hello from fallback");

        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                while (true){
                    System.out.println(supplier1.get());
                }
            }).start();
        }

        try {
            Thread.currentThread().wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static List<Class<? extends Throwable>> asList(Class<? extends Throwable>... class_ ) {
        return Arrays.stream(class_).collect(Collectors.toList());
    }


    public static String sayHelloWorld(String p){
        return p+" hello world";
    }
}
