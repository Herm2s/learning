package com.hermes.heima_juc.cas;

import sun.misc.Unsafe;

/**
 * @author liu.zongbin
 * @since 2022/9/5 22:27
 */
public class AtomicData {

    private volatile int data;

    static final Unsafe UNSAFE;

    static final long DATA_OFFSET;

    static {
        UNSAFE = UnsafeAccessor.getUnsafe();
        try {
            DATA_OFFSET = UNSAFE.objectFieldOffset(AtomicData.class.getDeclaredField("data"));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    public AtomicData(int data) {
        this.data = data;
    }

    public void decrease(int amount) {
        int oldValue;
        while (true) {
            // 获取共享变量的旧值，可以在这一行加入断点，修改data调试来加深理解
            oldValue = data;
            // cas尝试修改data为旧值 + amount，如果期间旧值被别的线程改了，返回false
            if (UNSAFE.compareAndSwapInt(this, DATA_OFFSET, oldValue, oldValue - amount)) {
                return;
            }
        }
    }

    public int getData() {
        return data;
    }

    public static void main(String[] args) {
        Account.demo(new Account() {
            final AtomicData atomicData = new AtomicData(10000);

            @Override
            public Integer getBalance() {
                return atomicData.getData();
            }

            @Override
            public void withdraw(Integer amount) {
                atomicData.decrease(amount);
            }
        });
    }
}
