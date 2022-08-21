package com.hermes.designpattern.command;

/**
 * @author liu.zongbin
 * @since 2022/8/21 15:55
 */
public class TVReceiver {

    public void on() {
        System.out.println("电视打开了");
    }

    public void off() {
        System.out.println("电视关闭了");
    }
}
