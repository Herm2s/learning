package com.hermes.designpattern.visitor;

/**
 * @author liu.zongbin
 * @since 2022/8/22 22:08
 */
public abstract class Action {

    /**
     * 男性测评
     */
    public abstract void getManResult(Man man);

    /**
     * 女性测评
     */
    public abstract void getWomanResult(Woman man);
}
