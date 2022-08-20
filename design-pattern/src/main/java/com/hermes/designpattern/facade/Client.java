package com.hermes.designpattern.facade;

/**
 * @author liu.zongbin
 * @since 2022/8/20 15:17
 */
public class Client {

    public static void main(String[] args) {

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.ready();
        homeTheaterFacade.play();

        homeTheaterFacade.end();
    }
}
