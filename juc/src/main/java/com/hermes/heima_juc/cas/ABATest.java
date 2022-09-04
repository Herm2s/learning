package com.hermes.heima_juc.cas;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

import static com.hermes.heima_juc.util.Sleeper.sleep;

/**
 * @author liu.zongbin
 * @since 2022/9/4 21:55
 */
@Slf4j(topic = "ABATest")
public class ABATest {

    static AtomicReference<String> ref = new AtomicReference<>("A");

    public static void main(String[] args) {
        log.debug("main start...");
        // 获取值 A
        // 这个共享变量被它线程修改过？
        String prev = ref.get();
        other();
        sleep(1);
        // 尝试改为 C
        log.debug("change A->C {}", ref.compareAndSet(prev, "C"));

    }

    private static void other() {
        new Thread(() -> {
            log.debug("change A->B {}", ref.compareAndSet(ref.get(), "B"));
        }, "t1").start();
        sleep(0.5);
        new Thread(() -> {
            log.debug("change B->A {}", ref.compareAndSet(ref.get(), "A"));
        }, "t2").start();
    }
}
