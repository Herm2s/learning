package com.hermes.others.multithread;

/**
 * @author liu.zongbin
 * @since 2022/11/30
 */
public class BasicThreads {

    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
