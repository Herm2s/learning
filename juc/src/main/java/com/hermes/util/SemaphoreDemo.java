package com.hermes.util;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 * 6辆汽车停3个停车位
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/5
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 设置车位数量
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                // 防止多释放问题
                boolean acquire = false;
                try {
                    // 抢车位
                    acquire =  semaphore.tryAcquire(10L, TimeUnit.SECONDS);
                    if (acquire) {
                        System.out.println(Thread.currentThread().getName() + " 抢到了车位");
                        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                        System.out.println(Thread.currentThread().getName() + " -------离开了了车位");
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    // 释放车位
                    if (acquire) {
                        semaphore.release();
                    }
                }
            }, String.valueOf(i)).start();
        }
    }
}
