package com.hermes.designpattern.adapter.interfaces;

/**
 * @author liu.zongbin
 * @since 2022/8/16 23:02
 */
public class Client {

    public static void main(String[] args) {
        AbstractAdapter abstractAdapter = new AbstractAdapter() {
            @Override
            public void m1() {
                System.out.println("使用了m1方法");
            }
        };

        abstractAdapter.m1();
    }
}
