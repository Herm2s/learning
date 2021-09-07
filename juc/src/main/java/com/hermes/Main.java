package com.hermes;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/4
 */
public class Main {

    public static void main(String[] args) {
        Thread aa = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "aa");
        // 设置守护线程
        aa.setDaemon(true);
        aa.start();
        System.out.println(Thread.currentThread().getName() + " over");
    }
}
