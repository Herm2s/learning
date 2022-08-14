package com.hermes.designpattern.singleton.type1;

/**
 * @author liu.zongbin
 * @since 2022/8/13 20:37
 */
public class SingletonTest1 {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}

/**
 * 饿汉式（静态变量）
 */
class Singleton {

    /**
     * 本类内部创建对象实例
     */
    private final static Singleton INSTANCE = new Singleton();

    /**
     * 构造方法私有化
     */
    private Singleton() {

    }

    /**
     * 提供公有方法返回唯一实例
     */
    public static Singleton getInstance() {
        return INSTANCE;
    }
}

