package com.hermes.algorithm.ratelimit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 固定窗口
 *
 * @author liu.zongbin
 * @date 2024/3/14
 */
public class FixedWindowLimiter {

    private final long windowSizeMillis;   // 窗口大小
    private final int maxRequests;   // 最大请求数
    private int requests;      // 当前窗口内的请求数
    private long lastReset;     // 上次窗口重置时间（秒级时间戳）
    private final Lock resetMutex = new ReentrantLock();    // 重置锁

    public FixedWindowLimiter(long windowSizeMillis, int maxRequests) {
        this.windowSizeMillis = windowSizeMillis;
        this.maxRequests = maxRequests;
        this.lastReset = System.currentTimeMillis();
    }

    public boolean allowRequest() {
        resetMutex.lock();
        try {
            // 检查是否需要重置窗口
            if (System.currentTimeMillis() - lastReset >= windowSizeMillis) {
                requests = 0;
                lastReset = System.currentTimeMillis();
            }
            // 检查请求是否超过阈值
            if (requests >= maxRequests) {
                return false;
            }

            requests++;
            return true;
        } finally {
            resetMutex.unlock();
        }
    }

    public static void main(String[] args) {
        // 每秒最多允许三个请求
        FixedWindowLimiter limiter = new FixedWindowLimiter(TimeUnit.SECONDS.toMillis(1L), 3);
        for (int i = 0; i < 15; i++) {
            String now = String.format("%tT", System.currentTimeMillis());
            if (limiter.allowRequest()) {
                System.out.println(now + " 请求通过");
            } else {
                System.out.println(now + " 请求被限流");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
