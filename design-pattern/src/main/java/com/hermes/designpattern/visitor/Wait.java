package com.hermes.designpattern.visitor;

/**
 * @author liu.zongbin
 * @since 2022/8/22 22:14
 */
public class Wait extends Action {

    @Override
    public void getManResult(Man man) {
        System.out.println("男人给的评价该歌手待定...");
    }

    @Override
    public void getWomanResult(Woman man) {
        System.out.println("女人给的评价该歌手待定...");
    }
}
