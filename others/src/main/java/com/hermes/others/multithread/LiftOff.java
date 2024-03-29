package com.hermes.others.multithread;

/**
 * @author liu.zongbin
 * @since 2022/11/30
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;

    private static int taskCount = 0;

    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#%d(%s). ".formatted(id, countDown > 0 ? countDown : "Liftoff!");
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}
