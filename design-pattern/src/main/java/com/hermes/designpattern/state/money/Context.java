package com.hermes.designpattern.state.money;

import lombok.Getter;
import lombok.Setter;

/**
 * 环境上下文
 *
 * @author liu.zongbin
 * @since 2022/8/30 21:30
 */
public class Context extends AbstractState {

    /**
     * 当前的状态，根据我们的业务流程不断变化
     */
    @Setter
    @Getter
    private State state;

    @Override
    public void checkEvent(Context context) {
        state.checkEvent(this);
        getCurrentState();
    }

    @Override
    public void checkFailEvent(Context context) {
        state.checkFailEvent(this);
        getCurrentState();
    }

    @Override
    public void makePriceEvent(Context context) {
        state.makePriceEvent(this);
        getCurrentState();
    }

    @Override
    public void acceptOrderEvent(Context context) {
        state.acceptOrderEvent(this);
        getCurrentState();
    }

    @Override
    public void notPeopleAcceptEvent(Context context) {
        state.notPeopleAcceptEvent(this);
        getCurrentState();
    }

    @Override
    public void payOrderEvent(Context context) {
        state.payOrderEvent(this);
        getCurrentState();
    }

    @Override
    public void orderFailureEvent(Context context) {
        state.orderFailureEvent(this);
        getCurrentState();
    }

    @Override
    public void feedBackEvent(Context context) {
        state.feedBackEvent(this);
        getCurrentState();
    }

    @Override
    public String getCurrentState() {
        System.out.println("当前状态: " + state.getCurrentState());
        return state.getCurrentState();
    }
}
