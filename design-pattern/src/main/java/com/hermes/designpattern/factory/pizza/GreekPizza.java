package com.hermes.designpattern.factory.pizza;

public class GreekPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("正在准备希腊风味披萨");
    }

}
