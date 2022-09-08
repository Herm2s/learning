package com.hermes.heima_juc.threadpool;


/**
 * @author liu.zongbin
 * @since 2022/9/6 21:31
 */
@FunctionalInterface
public interface RejectPolicy<T> {

    void reject(BlockingQueue<T> queue, T task);
}
