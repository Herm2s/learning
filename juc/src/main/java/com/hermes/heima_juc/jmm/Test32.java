package com.hermes.heima_juc.jmm;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author liu.zongbin
 * @since 2022/9/4 15:53
 */
@Slf4j(topic = "Test32")
public class Test32 {

    static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (run) {
                // ...
                // 加入这个语句，线程可以正常停止
                System.out.println(111);
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);
        log.debug("停止t");
        // 线程t不会如预想的停下来
        run = false;
    }
}
