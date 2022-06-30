package com.hermes.sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liu.zongbin
 * @created 2022/6/28 16:13
 */
public class WaitNotifyDemo {

    static Object objectLock = new Object();

    private static void synchronizedWaitNotify() {
        new Thread(() -> {
            //synchronized (objectLock) {
            System.out.println(Thread.currentThread().getName() + "\t" + "------come in");
            try {
                objectLock.wait(); // 等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "------被唤醒");
            //}
        }, "A").start();

        new Thread(() -> {
            //synchronized (objectLock) {
            objectLock.notify(); // 唤醒
            System.out.println(Thread.currentThread().getName() + "\t" + "------通知");
            //}
        }, "B").start();
    }

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    private static void lockAwaitSignal() {
        new Thread(() -> {
//            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "------come in");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "------被唤醒");
            } finally {
//                lock.unlock();
            }
        }, "A").start();


        new Thread(() -> {
//            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "------通知");
            } finally {
//                lock.unlock();
            }
        }, "B").start();
    }

    public static void main(String[] args) {
        lockAwaitSignal();
    }
}
