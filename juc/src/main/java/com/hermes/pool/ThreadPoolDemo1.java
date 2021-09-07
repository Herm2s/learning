package com.hermes.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/5
 */
public class ThreadPoolDemo1 {

    public static void main(String[] args) {
        // N线程
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);

        // 一线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();

        // 可扩容线程池
        ExecutorService threadPool3 = Executors.newCachedThreadPool();

        // 10个顾客
        try {
            for (int i = 0; i < 20; i++) {
                threadPool3.execute(() -> System.out.println(Thread.currentThread().getName() + " 办理业务"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool3.shutdown();
        }
    }
}
