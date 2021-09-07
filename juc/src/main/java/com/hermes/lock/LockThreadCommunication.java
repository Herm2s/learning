package com.hermes.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程间通信-Lock实现
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/4
 */
class Share {
    private int number = 0;

    private final Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void incr() throws InterruptedException {
        // 判断 操作 通知
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void decr() throws InterruptedException {
        // 判断 操作 通知
        lock.lock();
        try {
            while (number <= 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

public class LockThreadCommunication {

    public static void main(String[] args) {
        Share share = new Share();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    share.incr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程1").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    share.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程2").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    share.incr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程3").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    share.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程4").start();
    }
}
