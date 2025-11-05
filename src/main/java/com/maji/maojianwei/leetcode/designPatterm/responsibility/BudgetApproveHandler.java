package com.maji.maojianwei.leetcode.designPatterm.responsibility;

public abstract class BudgetApproveHandler {
    public String name ;
    private BudgetApproveHandler nextHandler;


    public BudgetApproveHandler getNextHandler() {
        return nextHandler;
    }
    public BudgetApproveHandler(String name){
        super();
        this.name = name;
    }

    /**
     * 审批方法
     * @param request
     */
    public abstract void approve(BudgetApproveRequest request);


    public void setNextHandler(BudgetApproveHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
