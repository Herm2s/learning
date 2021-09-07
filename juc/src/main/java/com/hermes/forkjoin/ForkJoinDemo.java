package com.hermes.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/5
 */
class MyTask extends RecursiveTask<Integer> {

    private static final long serialVersionUID = 3029110761304623858L;

    /**
     * 拆分差值不能超过10，计算10以内的运算
     */
    private static final Integer VALUE = 10;

    // 拆分开始值
    private final int begin;
    // 拆分结束值
    private final int end;
    // 计算结果
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    /**
     * 拆分和合并过程
     */
    @Override
    protected Integer compute() {
        // 判断
        if (this.end - this.begin <= VALUE) {
            // 相加操作
            for (int i = begin; i <= end; i++) {
                result = result + i;
            }
        } else {
            // 进一步拆分
            // 获取中间值
            int middle = (begin + end) / 2;
            // 拆分左边
            MyTask t1 = new MyTask(begin, middle);
            // 拆分右边
            MyTask t2 = new MyTask(middle + 1, end);
            // 调用方法拆分
            t1.fork();
            t2.fork();
            // 合并结果
            result = t1.join() + t2.join();
        }
        return result;
    }
}

public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建MyTask对象
        MyTask myTask = new MyTask(0, 100);
        // 创建分支合并池对象
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);
        Integer result = forkJoinTask.get();
        System.out.println(result);
        forkJoinPool.shutdown();
    }
}
