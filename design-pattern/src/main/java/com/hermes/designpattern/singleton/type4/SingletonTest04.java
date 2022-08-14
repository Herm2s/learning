package com.hermes.designpattern.singleton.type4;

/**
 * @author liu.zongbin
 * @since 2022/8/13 20:56
 */
public class SingletonTest04 {
}

/**
 * 懒汉式（线程安全，同步方法）
 */
class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    /**
     * instance不等于空时才创建
     */
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
