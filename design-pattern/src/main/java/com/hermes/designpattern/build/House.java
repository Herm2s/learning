package com.hermes.designpattern.build;

import lombok.Data;

/**
 * @author liu.zongbin
 * @since 2022/8/15 22:15
 */
@Data
public class House {

    /**
     * 地基
     */
    private String basic;

    /**
     * 墙
     */
    private String wall;

    /**
     * 屋顶
     */
    private String roof;
}
