package com.hermes.designpattern.facade;

/**
 * @author liu.zongbin
 * @since 2022/8/20 15:25
 */
public class Popcorn {

    private static Popcorn instance = new Popcorn();

    public static Popcorn getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" popcorn on ");
    }

    public void off() {
        System.out.println(" popcorn off ");
    }

    public void pop() {
        System.out.println(" popcorn is popping  ");
    }
}
