package com.hermes.sync;

import java.util.concurrent.TimeUnit;

/**
 * 死锁例子
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/4
 */
public class DeadLock {

    static final Object a = new Object();
    static final Object b = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "持有锁a，试图获取锁b");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + "获取锁b");
                }
            }
        }, "AA").start();
        new Thread(() -> {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "持有锁b，试图获取锁a");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "获取锁a");
                }
            }
        }, "BB").start();
    }
}
