package com.hermes.designpattern.singleton.type8;

/**
 * @author liu.zongbin
 * @since 2022/8/13 21:47
 */
public class SingletonTest08 {
    public static void main(String[] args) {

    }
}

/**
 * 枚举实现单例
 */
enum Singleton {

    /**
     * 实例
     */
    INSTANCE;

    public void sayOk() {
        System.out.println("OK~");
    }
}