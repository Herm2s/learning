package com.hermes.meituancf;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author herm2s
 * @since 2022/10/9 14:51
 */
public class FutureUtils {

    public static <T> CompletableFuture<T> toCompletableFuture(ThriftAsyncCall thriftAsyncCall) {
        CompletableFuture<T> resultFuture = new CompletableFuture<>();
        new Observer<T>() {
            @Override
            public void onSuccess(T t) {
                resultFuture.complete(t);
            }

            @Override
            public void onFailure(Throwable throwable) {
                resultFuture.completeExceptionally(throwable);
            }
        };
        if (thriftAsyncCall != null) {
            try {
                thriftAsyncCall.invoke();
            } catch (Exception e) {
                resultFuture.completeExceptionally(e);
            }
        }
        return resultFuture;
    }

    public static <T> CompletableFuture<T> failed(Throwable ex) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        completableFuture.completeExceptionally(ex);
        return completableFuture;
    }

    /**
     * 设置CF状态为成功
     */
    public static <T> CompletableFuture<T> success(T result) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        completableFuture.complete(result);
        return completableFuture;
    }

    public static <T> CompletableFuture<List<T>> sequence(Collection<CompletableFuture<List<T>>> completableFutures) {
        return CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture<?>[0]))
                .thenApply(v -> completableFutures.stream()
                        .flatMap(listFuture -> listFuture.join().stream())
                        .collect(Collectors.toList())
                );
    }
}
