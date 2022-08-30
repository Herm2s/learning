package com.hermes.designpattern.state;

/**
 * @author liu.zongbin
 * @since 2022/8/30 20:41
 */
public class DispenseState extends State {

    private RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("不能扣除积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        if (this.activity.getCount() > 0) {
            System.out.println("恭喜中奖了");
            this.activity.setState(activity.getNoRaffleState());
        } else {
            System.out.println("很遗憾，奖品发送完了");
            // 改变状态为奖品发送完璧
            activity.setState(activity.getDispenseOutState());
        }
    }
}
