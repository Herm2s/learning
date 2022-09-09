package com.hermes.heima_juc.threadpool;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author liu.zongbin
 * @since 2022/9/8
 */
public class TestTimedTask {

    public static void main(String[] args) {
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        // 获取本周四 18:00:00.000
        LocalDateTime thursday = now.with(DayOfWeek.THURSDAY)
                .withHour(18)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        // 如果当前时间已经超过 本周四 18:00:00.000， 那么找下周四 18:00:00.000
        if (now.compareTo(thursday) > 0) {
            thursday = thursday.plusWeeks(1L);
        }
        // 计算时间差，即延时执行时间
        long initialDelay = Duration.between(now, thursday).toMillis();
        // 计算间隔时间，即 1 周的毫秒值
        long oneWeek = 7 * 24 * 3600 * 1000L;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        System.out.println("开始时间：" + new Date());
        executor.scheduleAtFixedRate(
                () -> System.out.println("执行时间：" + new Date()),
                initialDelay,
                oneWeek,
                TimeUnit.MILLISECONDS);
    }
}
