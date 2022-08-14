package com.hermes.designpattern.factory.factorymethod;


import com.hermes.designpattern.factory.pizza.Pizza;

/**
 * 订购披萨
 *
 * @author liu.zongbin
 * @since 2022/8/14 15:39
 */
public abstract class PizzaStore {

    /**
     * 定义一个创建pizza的抽象方法，留给子类实现
     */
    abstract Pizza createPizza(String pizzaType);

    /**
     * 根据披萨类型订购披萨
     */
    public Pizza orderPizza(String pizzaType) {
        Pizza pizza = this.createPizza(pizzaType);
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
        LondonPizzaStore store = new LondonPizzaStore();
        Pizza pizza = store.orderPizza("cheese");
        System.out.println("披萨类型：" + pizza.getName());
    }
}

