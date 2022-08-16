package com.hermes.designpattern.adapter;

/**
 * @author liu.zongbin
 * @since 2022/8/16 22:24
 */
public class Voltage220V {

    public int output220V() {
        int src = 220;
        System.out.println("电压=" + src + "伏");
        return src;
    }
}
