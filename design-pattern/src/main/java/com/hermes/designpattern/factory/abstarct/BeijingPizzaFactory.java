package com.hermes.designpattern.factory.abstarct;

import com.hermes.designpattern.factory.factorymethod.pizza.BeijingCheesePizza;
import com.hermes.designpattern.factory.factorymethod.pizza.BeijingPepperPizza;
import com.hermes.designpattern.factory.pizza.Pizza;

/**
 * @author liu.zongbin
 * @since 2022/8/14 19:08
 */
public class BeijingPizzaFactory implements PizzaFactory {

    @Override
    public Pizza createPizza(String pizzaType) {
        System.out.println("使用的是抽象工厂模式~");
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
