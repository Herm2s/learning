package com.hermes.designpattern.visitor;

/**
 * @author liu.zongbin
 * @since 2022/8/22 22:10
 */
public abstract class Person {

    /**
     * 提供一个方法，让访问者可以访问
     */
    public abstract void accept(Action action);
}
