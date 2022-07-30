package com.hermes;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/4
 */
public class Main {

    public static void main(String[] args) throws Exception {
//        Thread aa = new Thread(() -> {
//            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
//            while (true) {
//
//            }
//        }, "aa");
//        // 设置守护线程
//        aa.setDaemon(true);
//        aa.start();
//        System.out.println(Thread.currentThread().getName() + " over");
//
//        Thread t1 = new Thread();
//        t1.start();
//        t1.stop();

//        Callable<String> callable = () -> "Hello";
//        callable.call();
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws InterruptedException {
                TimeUnit.SECONDS.sleep(2);
                return "hello";
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
