package com.hermes.designpattern.factory.simple;

import com.hermes.designpattern.factory.pizza.CheesePizza;
import com.hermes.designpattern.factory.pizza.GreekPizza;
import com.hermes.designpattern.factory.pizza.PepperPizza;
import com.hermes.designpattern.factory.pizza.Pizza;

/**
 * 简单工厂模式
 *
 * @author liu.zongbin
 * @since 2022/8/14 17:29
 */
public class SimpleFactory {

    public Pizza createPizza(String orderType) {
        Pizza pizza = null;

        System.out.println("开始创建披萨");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("希腊风味披萨");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("起司披萨");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName("胡椒风味披萨");
        }

        return pizza;
    }
}
