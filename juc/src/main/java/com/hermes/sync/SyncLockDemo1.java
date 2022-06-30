package com.hermes.sync;

/**
 * @author liu.zongbin
 * @created 2022/6/28 15:19
 */
public class SyncLockDemo1 {

    static final Object lockObject = new Object();

    public static void m1() {
        synchronized (lockObject) {
            System.out.println("hello");
        }
    }
}
