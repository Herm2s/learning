package com.hermes.designpattern.decorator.seasoning;

import com.hermes.designpattern.decorator.Decorator;
import com.hermes.designpattern.decorator.Drink;

/**调料
 * @author liu.zongbin
 * @since 2022/8/18 21:27
 */
public class Soy extends Decorator {

    public Soy(Drink drink) {
        super(drink);
        super.setDes("豆浆");
        super.setPrice(1.5f);
    }
}
