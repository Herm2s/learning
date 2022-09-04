package com.hermes.heima_juc.cas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author liu.zongbin
 * @since 2022/9/4 22:27
 */
public class AtomicArrayTest {

    /**
     * @param arraySupplier 提供数组、可以是线程不安全数组或线程安全数组
     * @param lengthFun     获取数组长度的方法
     * @param putConsumer   自增方法，回传 array, index
     * @param printConsumer 打印数组的方法
     */
    private static <T> void demo(Supplier<T> arraySupplier,
                                 Function<T, Integer> lengthFun,
                                 BiConsumer<T, Integer> putConsumer,
                                 Consumer<T> printConsumer) {
        List<Thread> ts = new ArrayList<>();
        T array = arraySupplier.get();
        int length = lengthFun.apply(array);
        for (int i = 0; i < length; i++) {
            // 每个线程对数组作 10000 次操作
            ts.add(new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    putConsumer.accept(array, j % length);
                }
            }));
        }
        // 启动所有线程
        ts.forEach(Thread::start);
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }); // 等所有线程结束
        printConsumer.accept(array);
    }

    public static void main(String[] args) {
        demo(
                () -> new int[10],
                (array) -> array.length,
                (array, index) -> array[index]++,
                array -> System.out.println(Arrays.toString(array))
        );

        demo(
                () -> new AtomicIntegerArray(10),
                AtomicIntegerArray::length,
                AtomicIntegerArray::getAndIncrement,
                System.out::println
        );
    }
}
