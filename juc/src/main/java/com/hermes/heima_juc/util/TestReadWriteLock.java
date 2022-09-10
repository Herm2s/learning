package com.hermes.heima_juc.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liu.zongbin
 * @since 2022/9/10
 */
@Slf4j(topic = "TestReadWriteLock")
public class TestReadWriteLock {

    public static void main(String[] args) {
        DataContainer dataContainer = new DataContainer();
        new Thread(dataContainer::read, "t1").start();
        new Thread(dataContainer::write, "t2").start();
    }
}

@Slf4j(topic = "DataContainer")
class DataContainer {

    private Object data;

    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = rw.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = rw.writeLock();

    public Object read() {
        log.debug("获取读锁...");
        readLock.lock();
        log.debug("获取读锁成功...");
        try {
            log.debug("读取数据...");
            Sleeper.sleep(1);
            return data;
        } finally {
            log.debug("释放读锁...");
            readLock.unlock();
        }
    }

    public void write() {
        log.debug("获取写锁...");
        writeLock.lock();
        log.debug("获取写锁成功...");
        try {
            log.debug("写入数据...");
        } finally {
            log.debug("释放写锁...");
            writeLock.unlock();
        }
    }
}
