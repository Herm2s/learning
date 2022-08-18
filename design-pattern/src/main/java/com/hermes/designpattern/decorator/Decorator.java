package com.hermes.designpattern.decorator;

/**
 * @author liu.zongbin
 * @since 2022/8/18 21:16
 */
public class Decorator extends Drink {

    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDes() {
        return des + "" + super.getPrice() + " && " + drink.getDes();
    }
}
