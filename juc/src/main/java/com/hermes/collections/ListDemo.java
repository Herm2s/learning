package com.hermes.collections;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * List集合线程不安全
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/4
 */
public class ListDemo {

    public static void main(String[] args) {
        // 创建ArrayList
        //        List<String> list = new ArrayList<>();
        // Vector解决
        //        List<String> list = new Vector<>();
        //
        //        List<String> list = Collections.synchronizedList(new ArrayList<>());

        //        for (int i = 0; i < 10; i++) {
        //            new Thread(() -> {
        //                extracted(list);
        //            }, String.valueOf(i)).start();
        //        }

        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                extracted(list);
            }, String.valueOf(i)).start();
        }
    }

    private synchronized static void extracted(List<String> list) {
        // 向集合添加内容
        list.add(UUID.randomUUID().toString().substring(0, 8));
        // 从集合获取内容
        System.out.println(list);
    }
}
