package com.hermes.designpattern.memento.game;


import lombok.Getter;
import lombok.Setter;

/**
 * @author liu.zongbin
 * @since 2022/8/27
 */
public class Caretaker {

    /**
     * 如果只保存一次状态
     */
    @Setter
    @Getter
    private Memento memento;

    /**
     * 保存多个状态
     */
//    private List<Memento> mementoList = new ArrayList<>();

    /**
     * 对多个游戏角色保存多个状态
     */
//    private HashMap<String, List<Memento>> rolesMementos;
}
