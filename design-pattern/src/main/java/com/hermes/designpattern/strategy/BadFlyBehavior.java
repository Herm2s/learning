package com.hermes.designpattern.strategy;

/**
 * @author liu.zongbin
 * @since 2022/8/31 21:48
 */
public class BadFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("飞翔技术一般");
    }
}
