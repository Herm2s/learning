package com.hermes.designpattern.prototype.improve;

import lombok.Data;

/**
 * @author liu.zongbin
 * @since 2022/8/14 21:06
 */
@Data
public class Sheep implements Cloneable {

    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 颜色
     */
    private String color;

    /**
     * 地址
     */
    private String address = "蒙古羊";

    /**
     * 朋友，克隆时默认是浅拷贝
     */
    private Sheep friend;

    public Sheep(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public Sheep clone() {
        try {
            return (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
