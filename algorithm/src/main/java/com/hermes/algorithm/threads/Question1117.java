package com.hermes.algorithm.threads;

/**
 * leetcode题号1117
 *
 * @author liu.zongbin
 * @since 2022/8/12
 */
public class Question1117 {

    public Question1117() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
    }
}
