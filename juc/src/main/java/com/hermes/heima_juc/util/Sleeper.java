package com.hermes.heima_juc.util;

import java.util.concurrent.TimeUnit;

/**
 * @author liu.zongbin
 * @since 2022/9/4 16:14
 */
public class Sleeper {

    public static void sleep(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(double i) {
        try {
            TimeUnit.MILLISECONDS.sleep((int) (i * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
