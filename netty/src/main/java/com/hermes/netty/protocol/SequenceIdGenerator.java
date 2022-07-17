package com.hermes.netty.protocol;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liu.zongbin
 * @since 2022/7/17 13:38
 */
public abstract class SequenceIdGenerator {

    private static final AtomicInteger ID = new AtomicInteger();

    public static int nextId() {
        return ID.incrementAndGet();
    }
}
