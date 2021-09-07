package com.hermes.util;

import java.util.concurrent.CountDownLatch;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/5
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 号同学离开了教室");
                latch.countDown();
            }, String.valueOf(i))
                .start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "班长锁门走人了");
    }
}
