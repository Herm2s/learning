package com.hermes.heima_juc.threadpool;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author liu.zongbin
 * @since 2022/9/6 22:20
 */
@Slf4j(topic = "ThreadPool")
public class ThreadPool {

    /**
     * 任务队列
     */
    private final BlockingQueue<Runnable> taskQueue;

    /**
     * 线程集合
     */
    private final Set<Worker> workers = new HashSet();

    /**
     * 核心线程数
     */
    private final int coreSize;

    /**
     * 获取任务的超时时间
     */
    private final long timeout;

    private final TimeUnit timeUnit;

    /**
     * 拒绝策略
     */
    private final RejectPolicy<Runnable> rejectPolicy;

    public ThreadPool(int coreSize, long timeout, TimeUnit timeUnit, int queueCapacity, RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue = new BlockingQueue<>(queueCapacity);
        this.rejectPolicy = rejectPolicy;
    }

    public void execute(Runnable task) {
        synchronized (workers) {
            if (workers.size() < coreSize) {
                // 当任务数没有超过coreSize时，直接交给worker对象执行
                Worker worker = new Worker(task);
                log.debug("新增worker：{}, 任务：{}", worker, task);
                workers.add(worker);
                worker.start();
            } else {
                // 如果任务数超过coreSize时，加入队列暂存
                // taskQueue.put(task);
                // 当阻塞队列已满时，就无法加入新的任务，这时有几种处理方式：
                // 1. 一直阻塞等待
                // 2. 带超时等待
                // 3. 让调用者放弃任务执行
                // 4. 让调用者抛出异常
                // 5. 让调用者自己执行任务
                taskQueue.tryPut(rejectPolicy, task);
            }
        }
    }

    @EqualsAndHashCode(callSuper = false)
    class Worker extends Thread {

        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            // 执行任务
            // 1. 当task不空，执行任务
            // 2. 当task执行完毕，再接着从任务队列获取任务并执行
            while (task != null || (task = taskQueue.poll(timeout, timeUnit)) != null) {
                log.debug("执行任务：{}", task);
                try {
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    task = null;
                }
            }
            synchronized (workers) {
                log.debug("worker被移除...{}", this);
                workers.remove(this);
            }
        }
    }
}
