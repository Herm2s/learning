package com.hermes.designpattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/8/27
 */
public class Caretaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        this.mementoList.add(memento);
    }

    public Memento get(int index) {
        return this.mementoList.get(index);
    }
}
