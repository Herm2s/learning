package com.hermes.collections;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/4
 */
public class SetDemo {

    public static void main(String[] args) {
        //        Set<String> set = new HashSet<>();
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                // 向集合添加内容
                set.add(UUID.randomUUID().toString().substring(0, 8));
                // 从集合获取内容
                System.out.println(set.toString());
            }, String.valueOf(i)).start();
        }
    }
}
