package com.hermes.designpattern.adapter.cls;

import com.hermes.designpattern.adapter.Phone;

/**
 * @author liu.zongbin
 * @since 2022/8/16 22:20
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("类适配器模式");

        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
