package com.hermes.heima_juc.threadpool;

import com.hermes.heima_juc.util.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author liu.zongbin
 * @since 2022/9/7 22:09
 */
@Slf4j(topic = "TestTimer")
public class TestTimer {

    public static void main(String[] args) {
        scheduleWithFixedDelay();
    }

    private static void scheduleWithFixedDelay() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        log.debug("start...");
        pool.scheduleWithFixedDelay(() -> {
            log.debug("running...");
            // Sleeper.sleep(2);
        }, 1, 1, TimeUnit.SECONDS);
    }

    private static void scheduleAtFixedRate() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        log.debug("start...");
        pool.scheduleAtFixedRate(() -> {
            log.debug("running...");
            // Sleeper.sleep(2);
        }, 1, 1, TimeUnit.SECONDS);
    }

    private static void timer() {
        Timer timer = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                log.debug("task1");
                Sleeper.sleep(2);
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                log.debug("task2");
                Sleeper.sleep(2);
            }
        };
        log.debug("start...");
        timer.schedule(task1, 1000);
        timer.schedule(task2, 1000);
    }

    private static void schedule() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        pool.schedule(() -> {
            log.debug("任务1执行时间：" + new Date());
            Sleeper.sleep(2);
        }, 1000, TimeUnit.MILLISECONDS);
        pool.schedule(() -> {
            log.debug("任务2执行时间：" + new Date());
        }, 1000, TimeUnit.MILLISECONDS);
    }
}
