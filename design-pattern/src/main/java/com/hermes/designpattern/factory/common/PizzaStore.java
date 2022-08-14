package com.hermes.designpattern.factory.common;

import com.hermes.designpattern.factory.pizza.CheesePizza;
import com.hermes.designpattern.factory.pizza.GreekPizza;
import com.hermes.designpattern.factory.pizza.PepperPizza;
import com.hermes.designpattern.factory.pizza.Pizza;

/**
 * 订购披萨
 *
 * @author liu.zongbin
 * @since 2022/8/14 15:39
 */
public class PizzaStore {

    /**
     * 根据披萨类型订购披萨
     */
    public Pizza orderPizza(String pizzaType) {
        Pizza result;

        if ("greek".equals(pizzaType)) {
            result = new GreekPizza();
            result.setName("希腊风味披萨");

        } else if ("cheese".equals(pizzaType)) {
            result = new CheesePizza();
            result.setName("起司披萨");

        } else if ("pepper".equals(pizzaType)) {
            result = new PepperPizza();
            result.setName("胡椒风味披萨");
        } else {
            throw new IllegalArgumentException("不支持此披萨类型");
        }

        result.prepare();
        result.bake();
        result.cut();
        result.box();
        return result;
    }


    public static void main(String[] args) {
        PizzaStore store = new PizzaStore();
        Pizza pizza = store.orderPizza("pepper");
        System.out.println("披萨类型：" + pizza.getName());
    }
}

