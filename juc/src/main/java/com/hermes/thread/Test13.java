package com.hermes.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liu.zongbin
 * @since 2022/8/1 15:34
 */
@Slf4j
public class Test13 {

    static int count = 0;

    static final private Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i < 5000; i++) {
                    count++;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i < 5000; i++) {
                    count--;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("count的值是{}", count);
    }
}
