package com.maji.maojianwei.leetcode.designPatterm.responsibility;

public class DepartmentHandler extends BudgetApproveHandler{
    private static final float PRICE_LOWER = 0;
    private static final float PRICE_UPPER = 10000;

    public DepartmentHandler(String name){
        super(name);
    }

    @Override
    public void approve(BudgetApproveRequest request) {
        if (request.getBudget() > PRICE_LOWER && request.getBudget() <= PRICE_UPPER) {
            System.out.println(String.format("%s processed , done", name));
        } else {
            getNextHandler().approve(request);
        }
    }
}
