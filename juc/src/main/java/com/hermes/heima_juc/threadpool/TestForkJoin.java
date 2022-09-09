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
        System.out.println("计算结果：" + pool.invoke(new AddTask2(1, 10)));
    }
}

@Slf4j(topic = "AddTask2")
class AddTask2 extends RecursiveTask<Integer> {

    int begin;

    int end;

    public AddTask2(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return "{" + begin + "," + end + '}';
    }

    @Override
    protected Integer compute() {
        if (begin == end) {
            log.debug("join() {}", begin);
            return begin;
        }

        if (end - begin == 1) {
            log.debug("join() {} + {} = {}", begin, end, end + begin);
            return end + begin;
        }

        // 1 5
        int mid = (end + begin) / 2; // 3
        AddTask2 t1 = new AddTask2(begin, mid); // 1,3
        t1.fork();
        AddTask2 t2 = new AddTask2(mid + 1, end); // 4,5
        t2.fork();
        log.debug("fork() {} + {} = ?", t1, t2);
        int result = t1.join() + t2.join();
        log.debug("join() {} + {} = {}", t1, t2, result);
        return result;
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
