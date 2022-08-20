package com.hermes.designpattern.facade;

/**
 * @author liu.zongbin
 * @since 2022/8/20 15:32
 */
public class Screen {

    private static Screen instance = new Screen();

    public static Screen getInstance() {
        return instance;
    }




    public void up() {
        System.out.println(" Screen up ");
    }

    public void down() {
        System.out.println(" Screen down ");
    }
}
