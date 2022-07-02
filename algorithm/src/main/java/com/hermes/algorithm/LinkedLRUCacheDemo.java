package com.hermes.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liu.zongbin
 * @created 2022/7/1 14:51
 */
public class LinkedLRUCacheDemo<K, V> extends LinkedHashMap<K, V> {

    /**
     * 容量
     */
    private int capacity;

    public LinkedLRUCacheDemo(int capacity) {
        // accessOrder为true代表以访问顺序排序，false代表以插入顺序排序
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    /**
     * 这个方法默认是返回false的，不会删除，因此需要重写
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LinkedLRUCacheDemo<Integer, String> linkedLruCacheDemo = new LinkedLRUCacheDemo<>(3);

        linkedLruCacheDemo.put(1, "a");
        linkedLruCacheDemo.put(2, "b");
        linkedLruCacheDemo.put(3, "c");
        System.out.println(linkedLruCacheDemo.keySet());

        linkedLruCacheDemo.put(4, "d");
        System.out.println(linkedLruCacheDemo.keySet());

        linkedLruCacheDemo.put(3, "c");
        System.out.println(linkedLruCacheDemo.keySet());
        linkedLruCacheDemo.put(3, "c");
        System.out.println(linkedLruCacheDemo.keySet());
        linkedLruCacheDemo.put(3, "c");
        System.out.println(linkedLruCacheDemo.keySet());
        linkedLruCacheDemo.put(5, "x");
        System.out.println(linkedLruCacheDemo.keySet());
    }
}
