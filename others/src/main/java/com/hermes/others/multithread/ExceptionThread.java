package com.hermes.others.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liu.zongbin
 * @since 2022/12/1
 */
public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
