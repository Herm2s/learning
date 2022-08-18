package com.hermes.designpattern.decorator;

import com.hermes.designpattern.decorator.coffee.DeCaf;
import com.hermes.designpattern.decorator.coffee.LongBlack;
import com.hermes.designpattern.decorator.seasoning.Chocolate;
import com.hermes.designpattern.decorator.seasoning.Milk;

/**
 * @author liu.zongbin
 * @since 2022/8/18 21:28
 */
public class CoffeeBar {

    public static void main(String[] args) {

        // 2份巧克力+1份牛奶的LongBlack

        // 点一份LongBlack
        Drink order = new LongBlack();
        System.out.println("order 费用1=" + order.cost());
        System.out.println("order 描述=" + order.getDes());

        // 加入一份牛奶
        order = new Milk(order);
        System.out.println("order 加入1份牛奶，费用=" + order.cost());
        System.out.println("order 加入1份牛奶，描述=" + order.getDes());

        // 加入一份巧克力
        order = new Chocolate(order);
        System.out.println("order 加入1份牛奶,加入1份巧克力，费用=" + order.cost());
        System.out.println("order 加入1份牛奶,加入1份巧克力，描述=" + order.getDes());

        // 加入一份巧克力
        order = new Chocolate(order);
        System.out.println("order 加入1份牛奶,加入2份巧克力，费用=" + order.cost());
        System.out.println("order 加入1份牛奶,加入2份巧克力，描述=" + order.getDes());

        System.out.println("==================================");


        Drink order2 = new DeCaf();
        System.out.println("order2 无因咖啡，费用=" + order2.cost());
        System.out.println("order2 无因咖啡，描述=" + order2.getDes());

        // 加入一份牛奶
        order2 = new Milk(order2);
        System.out.println("order2 加入1份牛奶，费用=" + order2.cost());
        System.out.println("order2 加入1份牛奶，描述=" + order2.getDes());
    }
}
