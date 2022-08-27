package com.hermes.designpattern.memento;

import lombok.Getter;

/**
 * @author liu.zongbin
 * @since 2022/8/27
 */
public class Memento {

    @Getter
    private String state;

    public Memento(String state) {
        this.state = state;
    }
}
