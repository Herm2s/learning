package com.hermes.designpattern.decorator.coffee;

/**
 * @author liu.zongbin
 * @since 2022/8/18 21:22
 */
public class Espresso extends Coffee {

    public Espresso() {
        super.setDes("意式浓缩");
        super.setPrice(6.0f);
    }
}
