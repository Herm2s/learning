package com.hermes.designpattern.strategy;

/**
 * @author liu.zongbin
 * @since 2022/8/31 21:52
 */
public class ToyDuck extends Duck {

    public ToyDuck() {
        flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("~~玩具鸭~~");
    }

    @Override
    public void quack() {
        System.out.println("玩具鸭不能叫~~");
    }

    @Override
    public void swim() {
        System.out.println("玩具鸭不会游泳~~");
    }
}
