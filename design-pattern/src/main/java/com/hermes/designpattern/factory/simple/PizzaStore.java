package com.hermes.designpattern.factory.simple;


import com.hermes.designpattern.factory.pizza.Pizza;

/**
 * 订购披萨
 *
 * @author liu.zongbin
 * @since 2022/8/14 15:39
 */
public class PizzaStore {

    private final SimpleFactory simpleFactory;

    public PizzaStore(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
    }

    /**
     * 根据披萨类型订购披萨
     */
    public Pizza orderPizza(String pizzaType) {
        Pizza pizza = this.simpleFactory.createPizza(pizzaType);
        if (pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } else {
            System.out.println("没有这种披萨");
        }
        return pizza;
    }


    public static void main(String[] args) {
        PizzaStore store = new PizzaStore(new SimpleFactory());
        Pizza pizza = store.orderPizza("cheese");
        System.out.println("披萨类型：" + pizza.getName());
    }
}

