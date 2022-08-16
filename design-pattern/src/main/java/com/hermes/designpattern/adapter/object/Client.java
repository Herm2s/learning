package com.hermes.designpattern.adapter.object;

import com.hermes.designpattern.adapter.Phone;
import com.hermes.designpattern.adapter.Voltage220V;

/**
 * @author liu.zongbin
 * @since 2022/8/16 22:20
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("对象适配器模式");

        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }
}
