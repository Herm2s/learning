package com.hermes.heima_juc.cas;

import com.hermes.heima_juc.util.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 不要用于生产实践！！！
 *
 * @author liu.zongbin
 * @since 2022/9/5 21:29
 */
@Slf4j(topic = "LockCas")
public class LockCas {

    private AtomicInteger state = new AtomicInteger(0);

    public void lock() {
        while (true) {
            if (state.compareAndSet(0, 1)) {
                break;
            }
        }
    }

    public void unlock() {
        log.debug("unlock...");
        state.set(0);
    }

    public static void main(String[] args) {
        LockCas lock = new LockCas();
        new Thread(() -> {
            log.debug("begin...");
            lock.lock();
            try {
                log.debug("lock...");
                Sleeper.sleep(1);
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            log.debug("begin...");
            lock.lock();
            try {
                log.debug("lock...");
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
