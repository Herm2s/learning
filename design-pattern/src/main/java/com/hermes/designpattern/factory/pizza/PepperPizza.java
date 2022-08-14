package com.hermes.designpattern.factory.pizza;

public class PepperPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("正在准备胡椒风味披萨");
    }

}
