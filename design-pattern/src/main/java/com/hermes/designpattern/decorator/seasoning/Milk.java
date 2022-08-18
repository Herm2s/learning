package com.hermes.designpattern.decorator.seasoning;

import com.hermes.designpattern.decorator.Decorator;
import com.hermes.designpattern.decorator.Drink;

/**
 * @author liu.zongbin
 * @since 2022/8/18 21:24
 */
public class Milk extends Decorator {

    public Milk(Drink drink) {
        super(drink);
        super.setDes("牛奶");
        super.setPrice(2.0f);
    }
}
