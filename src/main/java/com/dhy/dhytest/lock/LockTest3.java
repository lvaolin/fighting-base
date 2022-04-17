package com.dhy.dhytest.lock;

import com.google.common.util.concurrent.RateLimiter;

public class LockTest3 {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(100);
        rateLimiter.acquire();
        rateLimiter.acquire(10);
        rateLimiter.setRate(120);
        rateLimiter.tryAcquire();
        rateLimiter.tryAcquire(333);
    }
}
