package com.hermes.designpattern.state.money;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liu.zongbin
 * @since 2022/8/30 21:24
 */
@AllArgsConstructor
public enum StateEnum {

    /**
     * 订单生成
     */
    GENERATE(1, "GENERATE"),

    /**
     * 已审核
     */
    REVIEWED(2, "REVIEWED"),

    /**
     * 已发布
     */
    PUBLISHED(3, "PUBLISHED"),

    /**
     * 待付款
     */
    NOT_PAY(4, "NOT_PAY"),

    /**
     * 已付款
     */
    PAID(5, "PAID"),

    /**
     * 已完结
     */
    FEED_BACKED(6, "FEED_BACKED");

    @Getter
    private final int key;

    @Getter
    private final String value;
}
