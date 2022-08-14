package com.hermes.algorithm.threads;

import java.util.function.IntConsumer;

/**
 * @author liu.zongbin
 * @since 2022/8/12
 */
public class Question1116 {

    private int n;

    private volatile int state;

    public Question1116(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state != 0) {
                Thread.yield();
            }
            printNumber.accept(0);
            if (i % 2 == 0) {
                state = 1;
            } else {
                state = 2;
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) {
                Thread.yield();
            }
            printNumber.accept(i);
            state = 0;
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (state != 2) {
                Thread.yield();
            }
            printNumber.accept(i);
            state = 0;
        }
    }

    public static void main(String[] args) {
        Question1116 question = new Question1116(10);
        new Thread(() -> {
            try {
                question.zero(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "zero").start();

        new Thread(() -> {
            try {
                question.odd(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "odd").start();

        new Thread(() -> {
            try {
                question.even(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "even").start();
    }
}
