package com.hermes.designpattern.singleton.type7;

/**
 * @author liu.zongbin
 * @since 2022/8/13 21:36
 */
public class SingletonTest07 {

    public static void main(String[] args) {

    }
}

/**
 * 静态内部类实现单例
 */
class Singleton {

    /**
     * 构造方法私有化
     */
    private Singleton() {

    }

    /**
     * 提供一个静态内部类，其中有一个静态属性Singleton
     */
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }


    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
