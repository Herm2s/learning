package com.hermes.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized可重入演示
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/4
 */
public class SyncLockDemo {

    public synchronized void add() {
        add();
    }

    public static void main(String[] args) {
        // synchronized
//        Object o = new Object();
//        new Thread(() -> {
//            synchronized (o) {
//                System.out.println(Thread.currentThread().getName() + " 外层");
//                synchronized (o) {
//                    System.out.println(Thread.currentThread().getName() + " 中层");
//                    synchronized (o) {
//                        System.out.println(Thread.currentThread().getName() + " 内层");
//                    }
//                }
//            }
//        }, "t1").start();

        // Lock演示可重入锁
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " 外层");
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " 中层");
                    try {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + " 内层");
                    } finally {
                        lock.unlock();
                    }
                } finally {
                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }
        }, "t1").start();
    }
}
