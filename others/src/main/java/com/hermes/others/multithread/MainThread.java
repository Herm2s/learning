package com.hermes.others.multithread;

/**
 * @author liu.zongbin
 * @since 2022/11/30
 */
public class MainThread {

    public static void main(String[] args) {
        LiftOff launch = new LiftOff(10);
        launch.run();
    }
}
