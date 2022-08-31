package com.hermes.designpattern.strategy;

/**
 * @author liu.zongbin
 * @since 2022/8/31 21:56
 */
public class WildDuck extends Duck{

    public WildDuck() {
        flyBehavior = new GoodFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("这是野鸭");
    }
}
