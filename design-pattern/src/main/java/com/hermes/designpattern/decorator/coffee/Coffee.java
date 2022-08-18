package com.hermes.designpattern.decorator.coffee;

import com.hermes.designpattern.decorator.Drink;

/**
 * @author liu.zongbin
 * @since 2022/8/18 21:19
 */
public class Coffee extends Drink {

    @Override
    public float cost() {
        return super.getPrice();
    }
}
