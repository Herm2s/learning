package com.hermes.designpattern.state.money;

/**
 * 状态接口
 *
 * @author liu.zongbin
 * @since 2022/8/30 21:22
 */
public interface State {

    /**
     * 电审
     */
    void checkEvent(Context context);

    /**
     * 电审失败
     */
    void checkFailEvent(Context context);

    /**
     * 定价发布
     */
    void makePriceEvent(Context context);

    /**
     * 接单
     */
    void acceptOrderEvent(Context context);

    /**
     * 无人接单失败
     */
    void notPeopleAcceptEvent(Context context);

    /**
     * 付款
     */
    void payOrderEvent(Context context);

    /**
     * 接单有人支付失败
     */
    void orderFailureEvent(Context context);

    /**
     * 反馈
     */
    void feedBackEvent(Context context);

    /**
     * 获取当前状态
     */
    String getCurrentState();
}
