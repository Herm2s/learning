package com.hermes.designpattern.memento;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liu.zongbin
 * @since 2022/8/27
 */
public class Originator {

    @Setter
    @Getter
    private String state;

    public Memento saveStateMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        this.state = memento.getState();
    }
}
