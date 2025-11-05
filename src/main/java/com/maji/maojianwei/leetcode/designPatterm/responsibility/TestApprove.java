package com.maji.maojianwei.leetcode.designPatterm.responsibility;

public class TestApprove {
    public static void main(String[] args){
        // 责任链构建（可以不用按业务逻辑顺序）
        BudgetApproveHandler departmentHandler = new DepartmentHandler("department");
        BudgetApproveHandler collegeHandler    = new CollegeHandler("college");
        BudgetApproveHandler schoolHandler     = new SchoolHandler("school");
        departmentHandler.setNextHandler(schoolHandler);
        schoolHandler.setNextHandler(collegeHandler);
        collegeHandler.setNextHandler(departmentHandler);


        BudgetApproveRequest request1 = new BudgetApproveRequest(1, 10002);
        departmentHandler.approve(request1);
        BudgetApproveRequest request2 = new BudgetApproveRequest(2, 10);
        departmentHandler.approve(request2);
        BudgetApproveRequest request3 = new BudgetApproveRequest(3, 140002);
        departmentHandler.approve(request3);

    }
}
