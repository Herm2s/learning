package com.hermes.designpattern.factory.abstarct;

import com.hermes.designpattern.factory.factorymethod.pizza.LondonCheesePizza;
import com.hermes.designpattern.factory.factorymethod.pizza.LondonPepperPizza;
import com.hermes.designpattern.factory.pizza.Pizza;

/**
 * @author liu.zongbin
 * @since 2022/8/14 19:08
 */
public class LondonPizzaFactory implements PizzaFactory {
    
    @Override
    public Pizza createPizza(String pizzaType) {
        System.out.println("使用的是抽象工厂模式~");
        Pizza result = null;
        if ("cheese".equals(pizzaType)) {
            result = new LondonCheesePizza();
            result.setName("伦敦起司披萨");
        } else if ("pepper".equals(pizzaType)) {
            result = new LondonPepperPizza();
            result.setName("伦敦胡椒披萨");
        }
        return result;
    }
}
