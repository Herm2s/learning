package com.hermes.algorithm.threads;

import java.util.function.IntConsumer;

/**
 * 题号1195
 * <p>
 * 交替打印字符串
 *
 * @author liu.zongbin
 * @since 2022/8/15
 */
public class Question1195 {

    private int n;

    private volatile int flag = 0;

    private volatile int m = 1;

    public Question1195(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (m <= n) {
            while (flag != 1 && m <= n) {
                Thread.yield();
            }
            if (m > n) {
                return;
            }
            if (m % 3 == 0) {
                printFizz.run();
                flag = 0;
                m++;
            } else {
                flag = 2;
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (m <= n) {
            while (flag != 2 && m <= n) {
                Thread.yield();
            }
            if (m > n) {
                return;
            }
            if (m % 5 == 0) {
                printBuzz.run();
                flag = 0;
                m++;
            } else {
                flag = 3;
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (m <= n) {
            while (flag != 0 && m <= n) {
                Thread.yield();
            }
            if (m > n) {
                return;
            }
            if (m % 3 == 0 && m % 5 == 0) {
                printFizzBuzz.run();
                m++;
                flag = 0;
            } else {
                flag = 1;
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (m <= n) {
            while (flag != 3 && m <= n) {
                Thread.yield();
            }
            if (m > n) {
                return;
            }
            printNumber.accept(m);
            m++;
            flag = 0;
        }
    }

    public static void main(String[] args) {
        Question1195 task = new Question1195(15);
        new Thread(() -> {
            try {
                task.fizz(() -> System.out.print("fizz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                task.buzz(() -> System.out.print("buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                task.fizzbuzz(() -> System.out.print("fizzbuzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                task.number(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
