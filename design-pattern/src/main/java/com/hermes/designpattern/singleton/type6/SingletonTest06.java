package com.hermes.designpattern.singleton.type6;

/**
 * @author liu.zongbin
 * @since 2022/8/13 20:56
 */
public class SingletonTest06 {
}

/**
 * 懒汉式（双重检查）
 */
class Singleton {

    /**
     * volatile 禁止指令重排序
     */
    private static volatile Singleton instance;

    private Singleton() {

    }

    /**
     * instance不等于空时才创建
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
