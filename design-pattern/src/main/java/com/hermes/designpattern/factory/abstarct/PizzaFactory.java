package com.hermes.designpattern.factory.abstarct;

import com.hermes.designpattern.factory.pizza.Pizza;

/**
 * @author liu.zongbin
 * @since 2022/8/14 19:07
 */
public interface PizzaFactory {

    /**
     * 创建Pizza 由子类实现
     */
    Pizza createPizza(String pizzaType);
}
