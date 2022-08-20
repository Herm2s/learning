package com.hermes.designpattern.facade;

/**
 * @author liu.zongbin
 * @since 2022/8/20 15:18
 */
public class DVDPlayer {

    /**
     * 单例模式
     */
    private static DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" DVD on");
    }

    public void off() {
        System.out.println(" DVD off");
    }

    public void play() {
        System.out.println(" DVD playing");
    }

    public void pause() {
        System.out.println(" DVD pause...");
    }
}
