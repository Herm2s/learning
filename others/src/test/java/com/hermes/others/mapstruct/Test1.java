package com.hermes.others.mapstruct;

import cn.hutool.core.date.StopWatch;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author liu.zongbin
 * @since 2022/10/8
 */
class Test1 {

    @Test
    void test1() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        CompletableFuture<Void> c1 = CompletableFuture.runAsync(this::sleep);
        CompletableFuture<Void> c2 = CompletableFuture.runAsync(this::sleep);
        CompletableFuture.allOf(c1, c2).join();
        stopWatch.stop();
        System.out.println(stopWatch.shortSummary(TimeUnit.MILLISECONDS));
    }

    @Test
    void listenableFutureTest() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        ListeningExecutorService guavaExecutor = MoreExecutors.listeningDecorator(executor);
        ListenableFuture<String> future1 = guavaExecutor.submit(() -> {
            //step 1
            System.out.println("执行step 1");
            return "step1 result";
        });
        ListenableFuture<String> future2 = guavaExecutor.submit(() -> {
            //step 2
            System.out.println("执行step 2");
            return "step2 result";
        });
        ListenableFuture<List<String>> future1And2 = Futures.allAsList(future1, future2);
        Futures.addCallback(future1And2, new FutureCallback<>() {
            @Override
            public void onSuccess(List<String> result) {
                System.out.println(result);
                ListenableFuture<String> future3 = guavaExecutor.submit(() -> {
                    System.out.println("执行step 3");
                    return "step3 result";
                });
                Futures.addCallback(future3, new FutureCallback<>() {
                    @Override
                    public void onSuccess(String result) {
                        System.out.println(result);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                    }
                }, guavaExecutor);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        }, guavaExecutor);
    }

    @Test
    void completableFutureTest() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行step 1");
            return "step1 result";
        }, executor);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行step 2");
            return "step2 result";
        });
        cf1.thenCombine(cf2, (result1, result2) -> {
            System.out.println(result1 + " , " + result2);
            System.out.println("执行step 3");
            return "step3 result";
        }).thenAccept(result3 -> System.out.println(result3));
    }

    void sleep() {
        try {
            System.out.println("test");
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
