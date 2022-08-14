package com.hermes.designpattern.factory.factorymethod.pizza;

import com.hermes.designpattern.factory.pizza.Pizza;

public class BeijingPepperPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("正在准备北京胡椒风味披萨");
    }

}
