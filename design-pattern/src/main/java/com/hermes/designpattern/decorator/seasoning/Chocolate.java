package com.hermes.designpattern.decorator.seasoning;

import com.hermes.designpattern.decorator.Decorator;
import com.hermes.designpattern.decorator.Drink;

/**
 * @author liu.zongbin
 * @since 2022/8/18 21:20
 */
public class Chocolate extends Decorator {

    public Chocolate(Drink drink) {
        super(drink);
        super.setDes("巧克力");
        super.setPrice(3.0f);
    }
}
