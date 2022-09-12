package com.hermes.heima_juc.util;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author liu.zongbin
 * @since 2022/9/12 20:51
 */
public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iter = list.iterator();
        new Thread(() -> {
            list.remove(0);
            System.out.println(list);
        }
        ).start();

        Sleeper.sleep(1);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
