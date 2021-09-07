package com.hermes.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/4
 */
class MyThread1 implements Runnable {

    @Override
    public void run() {
        System.out.println(100);
    }
}

class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 200;
    }
}

public class Demo1 {

    public static void main(String[] args) throws Exception {
        new Thread(new MyThread1(), "AA").start();

        // FutureTask
        FutureTask<Integer> futureTask1 = new FutureTask<>(new MyThread2());

        // lambda
        FutureTask<Integer> futureTask2 = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + " come in callable");
            return 1024;
        });

        new Thread(futureTask2, "lucy").start();
        new Thread(futureTask1, "mary").start();
        while (!futureTask2.isDone()) {
            System.out.println("wait......");
        }
        System.out.println(futureTask2.get());
        System.out.println(futureTask1.get());
        System.out.println(Thread.currentThread().getName() + " come over");
        // FutureTask原理 未来任务
        /* 1. 老师上课，口渴了，去买水不合适，讲课线程继续。
         *   单开启线程找班长帮我买水
         *   把水买回来，需要的时候直接喝：get()
         * 2. 考试，先做会做的题目，最后看不会做的题目
         */
    }
}
