package com.hermes.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/5
 */
public class ThreadPoolDemo2 {

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
            5,
            2L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
        );

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " 办理业务"));
            }
        } finally {
            threadPool.shutdown();
        }
    }
}
