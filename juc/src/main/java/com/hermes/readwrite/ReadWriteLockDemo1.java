package com.hermes.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 写锁降级
 * 写锁是独占锁，必须没有读操作的时候才能写
 * 读锁是共享锁，有写操作的时候也可以读
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/5
 */

public class ReadWriteLockDemo1 {

    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        // 读锁
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        // 写锁
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        // 锁降级
        // 1.获取写锁
        writeLock.lock();
        System.out.println("write");

        // 2.获取读锁
        readLock.lock();
        System.out.println("----read");
        writeLock.unlock();
        readLock.unlock();
    }
}
