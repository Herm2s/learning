package com.hermes.heima_juc.cas;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author liu.zongbin
 * @since 2022/9/4 22:55
 */
public class Test5 {

    private volatile int field;

    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<Test5> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Test5.class, "field");
        Test5 test5 = new Test5();

        // 修改成功 field = 10
        fieldUpdater.compareAndSet(test5, 0, 10);
        System.out.println(test5.field);

        // 修改成功 field = 20
        fieldUpdater.compareAndSet(test5, 10, 20);
        System.out.println(test5.field);

        // 修改失败 field = 20
        fieldUpdater.compareAndSet(test5, 10, 30);
        System.out.println(test5.field);
    }
}
