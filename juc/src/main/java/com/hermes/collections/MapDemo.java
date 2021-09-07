package com.hermes.collections;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/4
 */
public class MapDemo {

    public static void main(String[] args) {
        //        Map<String, String> map = new HashMap<>();
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            String key = String.valueOf(i);
            new Thread(() -> {
                // 向集合添加元素
                String value = UUID.randomUUID().toString().substring(0, 8);
                System.out.println(value);
                map.put(key, value);
                // 从集合获取内容
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
