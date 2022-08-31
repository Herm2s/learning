package com.hermes.designpattern.strategy;

import lombok.Setter;

/**
 * @author liu.zongbin
 * @since 2022/8/31 21:46
 */
public abstract class Duck {

    @Setter
    FlyBehavior flyBehavior;

    @Setter
    QuackBehavior quackBehavior;

    public Duck() {

    }

    /**
     * 显示鸭子信息
     */
    public abstract void display();

    public void quack() {
        System.out.println("鸭子嘎嘎叫~~");
    }

    public void swim() {
        System.out.println("鸭子会游泳~~");
    }

    public void fly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }
}
