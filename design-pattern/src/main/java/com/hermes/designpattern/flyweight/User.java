package com.hermes.designpattern.flyweight;

import lombok.Data;

/**
 * @author liu.zongbin
 * @since 2022/8/20 16:17
 */
@Data
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }
}
