package com.hermes.designpattern.responsibilitychain;

import lombok.Setter;

/**
 * @author liu.zongbin
 * @since 2022/9/1 21:05
 */
public abstract class Approver {

    /**
     * 下一个处理者
     */
    @Setter
    Approver approver;

    /**
     * 名字
     */
    String name;

    public Approver(String name) {
        this.name = name;
    }

    /**
     * 审批采购请求
     *
     * @param purchaseRequest 采购请求
     */
    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
