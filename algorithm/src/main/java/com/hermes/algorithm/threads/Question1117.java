package com.hermes.algorithm.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * leetcode题号1117
 *
 * @author liu.zongbin
 * @since 2022/8/12
 */
public class Question1117 {

    public Question1117() {

    }

    private ReentrantLock reentrantLock = new ReentrantLock();

    private Condition condition = reentrantLock.newCondition();

    private int count = 1;

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        this.reentrantLock.lock();
        try {
            while (count == 0) {
                condition.await();
            }
            releaseHydrogen.run();
            if (count == 1) {
                count++;
            } else if (count == 2) {
                count = 0;
            }
            condition.signalAll();
        } finally {
            this.reentrantLock.unlock();

        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        this.reentrantLock.lock();
        try {
            while (count != 0) {
                condition.await();
            }
            releaseOxygen.run();
            count = 1;
            condition.signalAll();
        } finally {
            this.reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Question1117 task = new Question1117();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    task.hydrogen(() -> System.out.print("H"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    task.oxygen(() -> System.out.print("O"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
