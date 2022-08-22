package com.hermes.designpattern.visitor;

/**
 * @author liu.zongbin
 * @since 2022/8/22 22:13
 */
public class Woman extends Person {

    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
