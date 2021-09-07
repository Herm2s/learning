package com.hermes.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/5
 */
class MyCache {

    private final Map<String, Object> map = new HashMap<>();

    /**
     * 读写锁
     */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**
     * 放数据
     */
    public void put(String key, Object value) {
        // 添加读锁
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 正在写操作:" + key);
            TimeUnit.MICROSECONDS.sleep(300);
            // 放数据
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " 写完了:" + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    /**
     * 取数据
     */
    public Object get(String key) {
        Object result = null;
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 正在读取操作:" + key);
            TimeUnit.MICROSECONDS.sleep(300);
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 取完了:" + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
        return result;
    }
}

public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        // 创建线程放数据
        for (int i = 0; i < 5; i++) {
            final int num = i;
            new Thread(() -> myCache.put(String.valueOf(num), num + ""), String.valueOf(i))
                .start();
        }
        // 创建线程读数据
        for (int i = 0; i < 5; i++) {
            final int num = i;
            new Thread(() -> myCache.get(String.valueOf(num)), String.valueOf(i))
                .start();
        }
    }
}
