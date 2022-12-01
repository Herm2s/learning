package com.hermes.others.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liu.zongbin
 * @since 2022/12/1
 */
public class SettingDefaultHandler {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
