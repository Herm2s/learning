package com.hermes.designpattern.singleton.type2;

/**
 * @author liu.zongbin
 * @since 2022/8/13 20:37
 */
public class SingletonTest2 {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}

/**
 * 饿汉式（静态代码块）
 */
class Singleton {

    /**
     * 本类内部创建对象实例
     */
    private static final Singleton INSTANCE;

    static {
        // 在静态代码块中创建单例对象
        INSTANCE = new Singleton();
    }

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
