package com.hermes.heima_juc.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author liu.zongbin
 * @since 2022/9/8
 */
public class TestForkJoin {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("计算结果：" + pool.invoke(new AddTask1(5)));
    }
}

@Slf4j(topic = "AddTask1")
class AddTask1 extends RecursiveTask<Integer> {

    int n;

    public AddTask1(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        // 如果n已经为1，可以求得结果了
        if (n == 1) {
            log.debug("join() {}", n);
            return n;
        }
        // 将任务进行拆分(fork)
        AddTask1 t1 = new AddTask1(n - 1);
        t1.fork();
        log.debug("fork() {} + {}", n, t1);

        // 合并结果(join)
        int result = n + t1.join();
        log.debug("join() {} + {} = {}", n, t1, result);
        return result;
    }

    @Override
    public String toString() {
        return "{" + n + '}';
    }
}
