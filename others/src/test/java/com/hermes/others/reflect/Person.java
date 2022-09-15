package com.hermes.others.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author liu.zongbin
 * @since 2022/9/15
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    public int age;

    private Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("你好，我是" + name);
    }

    private String showNation(String nation) {
        System.out.println("喷子实在太多了！！！ " + nation);
        return nation;
    }
}
