package com.hermes.heima_juc.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liu.zongbin
 * @since 2022/9/11
 */
@Slf4j(topic = "TestCountdownLatch")
public class TestCountdownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService pool = Executors.newFixedThreadPool(4);
        pool.submit(() -> {
            log.debug("begin...");
            Sleeper.sleep(1);
            latch.countDown();
            log.debug("end... {} ", latch.getCount());
        });

        pool.submit(() -> {
            log.debug("begin...");
            Sleeper.sleep(2);
            latch.countDown();
            log.debug("end... {} ", latch.getCount());
        });

        pool.submit(() -> {
            log.debug("begin...");
            Sleeper.sleep(1.5);
            latch.countDown();
            log.debug("end... {} ", latch.getCount());
        });

        log.debug("waiting...");
        latch.await();
        log.debug("wait end...");
    }
}
