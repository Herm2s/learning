package com.hermes.heima_juc.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liu.zongbin
 * @since 2022/9/11
 */
@Slf4j(topic = "TestCyclicBarrier")
public class TestCyclicBarrier {

    public static void main(String[] args) {
        // 个数为2时才会执行
        CyclicBarrier barrier = new CyclicBarrier(2);
        new Thread(() -> {
            log.debug("t1开始..." + new Date());
            try {
                // 当个数不足时，等待
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            log.debug("t1继续运行" + new Date());
        }, "t1").start();

        new Thread(() -> {
            log.debug("t2开始..." + new Date());
            try {
                // 2秒后，线程个数够2，继续运行
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            log.debug("t2继续运行" + new Date());
        }, "t1").start();
    }
}
