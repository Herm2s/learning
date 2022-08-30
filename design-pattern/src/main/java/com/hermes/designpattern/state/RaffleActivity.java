package com.hermes.designpattern.state;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liu.zongbin
 * @since 2022/8/30 20:41
 */
public class RaffleActivity {

    /**
     * 当前活动的状态
     */
    @Setter
    @Getter
    private State state = null;

    /**
     * 奖品数量
     */
    private int count = 0;

    /**
     * 四个属性代表四种状态
     */
    @Setter
    @Getter
    private State noRaffleState = new NoRaffleState(this);
    @Setter
    @Getter
    private State canRaffleState = new CanRaffleState(this);

    @Setter
    @Getter
    private State dispenseState = new DispenseState(this);
    @Setter
    @Getter
    private State dispenseOutState = new DispenseOutState(this);

    /**
     * 构造器，初始化为不能抽奖的状态
     */
    public RaffleActivity(int count) {
        this.state = this.getNoRaffleState();
        this.count = count;
    }

    /**
     * 扣积分
     */
    public void deductMoney() {
        this.state.deductMoney();
    }

    /**
     * 抽奖
     */
    public void raffle() {
        if (this.state.raffle()) {
            this.state.dispensePrize();
        }
    }

    public int getCount() {
        int curCount = count;
        count--;
        return curCount;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
