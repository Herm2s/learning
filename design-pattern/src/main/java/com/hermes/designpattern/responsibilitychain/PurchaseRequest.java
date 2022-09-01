package com.hermes.designpattern.responsibilitychain;

import lombok.Getter;

/**
 * @author liu.zongbin
 * @since 2022/9/1 21:08
 */
public class PurchaseRequest {

    /**
     * 请求类型
     */
    @Getter

    private int type = 0;

    /**
     * 价格
     */
    @Getter
    private float price = 0.0f;

    /**
     * 请求编号
     */
    @Getter
    private int id = 0;

    public PurchaseRequest(int type, float price, int id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }
}
