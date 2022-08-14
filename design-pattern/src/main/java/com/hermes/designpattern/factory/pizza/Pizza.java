package com.hermes.designpattern.factory.pizza;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liu.zongbin
 * @since 2022/8/14 15:39
 */
public abstract class Pizza {

    /**
     * 披萨名
     */
    @Setter
    @Getter
    protected String name;

    /**
     * 准备步骤留给子类实现
     */
    public abstract void prepare();


    /**
     * 烘烤
     */
    public void bake() {
        System.out.println(name + " baking;");
    }

    /**
     * 切块
     */
    public void cut() {
        System.out.println(name + " cutting;");
    }

    /**
     * 打包
     */
    public void box() {
        System.out.println(name + " boxing;");
    }
}