package com.hermes.designpattern.visitor;

/**
 * @author liu.zongbin
 * @since 2022/8/22 22:11
 */
public class Man extends Person {

    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
