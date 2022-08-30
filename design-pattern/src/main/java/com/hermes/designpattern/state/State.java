package com.hermes.designpattern.state;

/**
 * @author liu.zongbin
 * @since 2022/8/30 20:38
 */
public abstract class State {

    /**
     * 扣除50积分
     */
    public abstract void deductMoney();

    /**
     * 是否抽中奖品
     */
    public abstract boolean raffle();

    /**
     * 发放奖品
     */
    public abstract void dispensePrize();
}
