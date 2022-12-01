package com.hermes.others.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liu.zongbin
 * @since 2022/11/30
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
