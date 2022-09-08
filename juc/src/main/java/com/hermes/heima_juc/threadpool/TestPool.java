package com.hermes.heima_juc.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author liu.zongbin
 * @since 2022/9/6 22:35
 */
@Slf4j(topic = "TestPool")
public class TestPool {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(2, 1000, TimeUnit.MILLISECONDS, 10,
                (queue, task) -> {
                    // 1. 一直阻塞等待
                    // queue.put(task);
                    // 2. 带超时等待
                    // queue.offer(task, 1500, TimeUnit.MILLISECONDS);
                    // 3. 让调用者放弃任务执行
                    // log.debug("放弃{}", task);
                    // 4. 让调用者抛出异常
                    // throw new RuntimeException("任务执行失败 " + task);
                    // 5. 让调用者自己执行任务
                    task.run();
                });
        for (int i = 0; i < 15; i++) {
            int j = i;
            threadPool.execute(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("{}", j);
            });
        }
    }
}
