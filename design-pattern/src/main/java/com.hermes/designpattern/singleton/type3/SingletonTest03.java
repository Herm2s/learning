package com.hermes.designpattern.singleton.type3;

/**
 * @author liu.zongbin
 * @since 2022/8/13 20:56
 */
public class SingletonTest03 {
}

/**
 * 懒汉式（线程不安全）
 */
class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    /**
     * instance不等于空时才创建
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
