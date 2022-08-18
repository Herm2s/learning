package com.hermes.designpattern.decorator;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liu.zongbin
 * @since 2022/8/18 21:14
 */
public abstract class Drink {

    @Setter
    @Getter
    public String des;

    @Setter
    @Getter
    private float price = 0.0f;

    /**
     * 计算费用的抽象方法
     */
    public abstract float cost();
}
