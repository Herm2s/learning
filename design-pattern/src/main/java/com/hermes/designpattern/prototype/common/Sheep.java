package com.hermes.designpattern.prototype.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liu.zongbin
 * @since 2022/8/14 21:06
 */
@Data
@AllArgsConstructor
public class Sheep {

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
}
