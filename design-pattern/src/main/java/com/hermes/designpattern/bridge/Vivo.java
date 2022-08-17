package com.hermes.designpattern.bridge;

/**
 * @author liu.zongbin
 * @since 2022/8/17 22:12
 */
public class Vivo implements Brand {

    @Override
    public void open() {
        System.out.println("ViVo手机开机");
    }

    @Override
    public void close() {
        System.out.println("ViVo手机关机");

    }

    @Override
    public void call() {
        System.out.println("ViVo手机打电话");

    }
}
