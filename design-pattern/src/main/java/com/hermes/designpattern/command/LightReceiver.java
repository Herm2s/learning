package com.hermes.designpattern.command;

/**
 * @author liu.zongbin
 * @since 2022/8/21 15:48
 */
public class LightReceiver {

    public void on() {
        System.out.println("电灯打开了");
    }

    public void off() {
        System.out.println("电灯关闭了");
    }
}
