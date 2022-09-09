package com.hermes.heima_juc.util;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author liu.zongbin
 * @since 2022/9/9 17:28
 */

@Slf4j(topic = "TestAqs")
public class TestAqs {
        public static void main(String[] args) {
            MyLock lock = new MyLock();
            new Thread(() -> {
                lock.lock();
                try {
                    log.debug("t1加锁成功");
                    Sleeper.sleep(1);
                } finally {
                    log.debug("t1解锁");
                    lock.unlock();
                }
            }, "t1").start();

            new Thread(() -> {
                lock.lock();
                try {
                    log.debug("t2加锁成功");
                } finally {
                    log.debug("t2解锁");
                    lock.unlock();
                }
            }, "t2").start();
        }
    }

    /**
     * 自定义不可重入锁
     */
    class MyLock implements Lock {

        private MySync sync = new MySync();

        /**
         * 独占锁，同步器类
         */
        class MySync extends AbstractQueuedSynchronizer {

            @Override
            protected boolean tryAcquire(int arg) {
                if (arg == 1) {
                    if (compareAndSetState(0, 1)) {
                        // 加锁成功, 并设置持有者为当前线程
                        setExclusiveOwnerThread(Thread.currentThread());
                        return true;
                    }
                }
                return false;
            }

            @Override
            protected boolean tryRelease(int arg) {
                if (arg == 1) {
                    if (getState() == 0) {
                        throw new IllegalMonitorStateException();
                    }
                    setExclusiveOwnerThread(null);
                    setState(0);
                    return true;
                }
                return false;
            }

            /**
             * 是否持有独占锁
             */
            @Override
            protected boolean isHeldExclusively() {
                return getState() == 1;
            }

            public Condition newCondition() {
                return new ConditionObject();
            }
        }

        /**
         * 加锁，不成功会进入队列等待
         */
        @Override
        public void lock() {
            sync.acquire(1);
        }

        /**
         * 加锁，可打断
         */
        @Override
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireInterruptibly(1);
        }

        /**
         * 尝试加锁（一次）
         */
        @Override
        public boolean tryLock() {
            return sync.tryAcquire(1);
        }

        /**
         * 尝试加锁，带超时时间
         */
        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return sync.tryAcquireNanos(1, unit.toNanos(time));
        }

        /**
         * 解锁
         */
        @Override
        public void unlock() {
            sync.release(1);
        }

        /**
         * 创建一个条件对象
         */
        @Override
        public Condition newCondition() {
            return sync.newCondition();
        }
    }
