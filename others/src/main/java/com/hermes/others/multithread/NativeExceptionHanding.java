package com.hermes.others.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liu.zongbin
 * @since 2022/12/1
 */
public class NativeExceptionHanding {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            exec.execute(new ExceptionThread());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
