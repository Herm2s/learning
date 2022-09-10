package com.hermes.heima_juc.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.StampedLock;

/**
 * @author liu.zongbin
 * @since 2022/9/10
 */
@Slf4j(topic = "TestStampedLock")
public class TestStampedLock {

    public static void main(String[] args) {
        DataContainerStamped dataContainer = new DataContainerStamped(1);
        new Thread(() -> dataContainer.read(1), "t1").start();
        Sleeper.sleep(0.5);
        new Thread(() -> dataContainer.write(100), "t2").start();
    }
}

@Slf4j(topic = "DataContainerStamped")
class DataContainerStamped {

    private int data;

    private final StampedLock lock = new StampedLock();

    public DataContainerStamped(int data) {
        this.data = data;
    }

    public int read(int readTime) {
        long stamp = lock.tryOptimisticRead();
        log.debug("optimistic read locking...{}", stamp);
        Sleeper.sleep(readTime);
        if (lock.validate(stamp)) {
            log.debug("read finish... {}, data: {}", stamp, data);
            return data;
        }
        // 锁升级 - 读锁
        log.debug("updating to read lock... {}", stamp);
        try {
            stamp = lock.readLock();
            log.debug("read lock {}", stamp);
            Sleeper.sleep(readTime);
            log.debug("read finish... {}, data: {}", stamp, data);
            return data;
        } finally {
            log.debug("read unlock {}", stamp);
            lock.unlockRead(stamp);
        }
    }

    public void write(int newData) {
        long stamp = lock.writeLock();
        log.debug("write lock {}", stamp);
        try {
            Sleeper.sleep(2);
            this.data = newData;
        } finally {
            log.debug("write unlock {}", stamp);
            lock.unlockWrite(stamp);
        }
    }
}
