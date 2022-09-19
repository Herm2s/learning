package com.hermes.others;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liu.zongbin
 * @created 2022/7/31 17:57
 */

class BloomFilterTest {

    ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 500, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(500));

    @Test
    void test() throws InterruptedException {
        BloomFilter<String> filter = BloomFilter.create(new Funnel<String>() {

            @Override
            public void funnel(String name, PrimitiveSink primitiveSink) {
                primitiveSink.putString(name, StandardCharsets.UTF_8);
            }
        }, 100000);
        for (int i = 0; i < 1000; i++) {
            int index = i;
            executor.execute(
                    () -> filter.put("zhangsan" + index)
            );
        }
        TimeUnit.SECONDS.sleep(10L);
        System.out.println(filter.mightContain("zhangsan"));
        System.out.println(filter.approximateElementCount());
    }
}
