package com.hermes.sync;

/**
 * 线程间通信-synchronized实现
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/4
 */
class Share {

    private int number = 0;

    public synchronized void incr() throws InterruptedException {
        // 判断 操作 通知
        while (number != 0) {
            // wait方法特点： 在哪里睡就在哪里醒
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "::" + number);
        this.notifyAll();
    }

    public synchronized void decr() throws InterruptedException {
        // 判断 操作 通知
        while (number <= 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "::" + number);
        this.notifyAll();
    }
}

public class ThreadCommunication {

    public static void main(String[] args) {

        Share share = new Share();
        new Thread(() -> {
            try {
                for (int i = 0; i < 40; i++) {
                    share.incr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程1").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 40; i++) {
                    share.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程2").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 40; i++) {
                    share.incr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程3").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 40; i++) {
                    share.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程4").start();
    }
}
