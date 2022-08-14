package com.hermes.designpattern.factory.pizza;

public class CheesePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("正在准备起司披萨");
    }

}
