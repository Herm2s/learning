package com.hermes.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/5
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 异步调用，没有返回值
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(
            () -> System.out.println(Thread.currentThread().getName() + " completableFuture1"));
        completableFuture1.get();
        // 异步调用，有返回值
        CompletableFuture<Object> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " completableFuture2");
            return 1024;
        });
        completableFuture2
            .whenComplete((t, u) -> {
                System.out.println("------t=" + t);
                System.out.println("------u=" + u);
            });
        System.out.println(completableFuture2.get());
    }
}
