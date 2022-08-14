package com.hermes.designpattern.singleton.type5;

/**
 * @author liu.zongbin
 * @since 2022/8/13 20:56
 */
public class SingletonTest05 {
}

/**
 * 懒汉式（线程安全，同步代码块）
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
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
