package com.hermes.designpattern.state;

/**
 * @author liu.zongbin
 * @since 2022/8/30 21:00
 */
public class Client {

    public static void main(String[] args) {
        RaffleActivity activity = new RaffleActivity(1);

        for (int i = 0; i < 20; i++) {
            System.out.println("------第" + (i + 1) + "次抽奖------");
            activity.deductMoney();
            activity.raffle();
        }
    }
}
