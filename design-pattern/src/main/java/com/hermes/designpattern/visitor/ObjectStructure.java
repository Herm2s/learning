package com.hermes.designpattern.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * 对象结构，管理了很多人
 *
 * @author liu.zongbin
 * @since 2022/8/22 22:15
 */
public class ObjectStructure {

    private List<Person> persons = new LinkedList<>();

    /**
     * 增加人
     */
    public void attach(Person person) {
        this.persons.add(person);
    }

    /**
     * 移除
     */
    public void detach(Person p) {
        persons.remove(p);
    }

    /**
     * 显示评测情况
     */
    public void display(Action action) {
        for (Person p : persons) {
            p.accept(action);
        }
    }
}
