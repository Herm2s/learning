package com.hermes.designpattern.state;

import java.util.Random;

/**
 * @author liu.zongbin
 * @since 2022/8/30 20:38
 */
public class CanRaffleState extends State{

    private RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("已经扣取过积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，请稍等！");
        Random random = new Random();
        int num = random.nextInt(10);
        // 10%中奖机会
        if (num == 0) {
            this.activity.setState(activity.getDispenseState());
            return true;
        }
        System.out.println("很遗憾没有抽中奖品！");
        this.activity.setState(activity.getNoRaffleState());
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("没中奖，不能发放奖品");
    }
}
