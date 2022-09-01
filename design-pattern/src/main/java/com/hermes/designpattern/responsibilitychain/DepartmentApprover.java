package com.hermes.designpattern.responsibilitychain;

/**
 * @author liu.zongbin
 * @since 2022/9/1 21:07
 */
public class DepartmentApprover extends Approver {

    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() <= 5000) {
            System.out.println("请求编号id: " + purchaseRequest.getId() + "被" + this.name + "处理");
        } else {
            approver.processRequest(purchaseRequest);
        }
    }
}
