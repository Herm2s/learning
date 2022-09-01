package com.hermes.designpattern.responsibilitychain;

/**
 * @author liu.zongbin
 * @since 2022/9/1 21:05
 */
public class Client {

    public static void main(String[] args) {
        // 创建采购请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 31000, 1);

        // 创建审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        CollegeApprover collegeApprover = new CollegeApprover("陈院长");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("李副校长");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("刘校长");

        // 设置下一级审批人
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        // 处理请求
        departmentApprover.processRequest(purchaseRequest);
        viceSchoolMasterApprover.processRequest(purchaseRequest);
    }
}
