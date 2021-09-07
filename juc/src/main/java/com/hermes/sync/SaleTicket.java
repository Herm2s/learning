package com.hermes.sync;

/**
 * 1. 创建资源类，定义属性和操作方法
 * 2. 创建多线程调用资源类操作方法
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/4
 */
class Ticket {

    private int number = 30;

    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + ":卖出一张，" + "剩下:" + --number);
        }
    }
}

public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "售票员-小明").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "售票员-小红").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "售票员-小强").start();
    }
}
