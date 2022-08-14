package com.hermes.designpattern.factory.factorymethod;

import com.hermes.designpattern.factory.factorymethod.pizza.BeijingCheesePizza;
import com.hermes.designpattern.factory.factorymethod.pizza.BeijingPepperPizza;
import com.hermes.designpattern.factory.pizza.Pizza;

/**
 * @author liu.zongbin
 * @since 2022/8/14 18:40
 */
public class BeijingPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String pizzaType) {
        Pizza result = null;
        if ("cheese".equals(pizzaType)) {
            result = new BeijingCheesePizza();
            result.setName("北京起司披萨");
        } else if ("pepper".equals(pizzaType)) {
            result = new BeijingPepperPizza();
            result.setName("北京胡椒披萨");
        }
        return result;
    }
}
