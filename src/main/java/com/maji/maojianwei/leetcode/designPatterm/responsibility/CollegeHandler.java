package com.maji.maojianwei.leetcode.designPatterm.responsibility;

public class CollegeHandler extends BudgetApproveHandler{
    private static final float PRICE_LOWER = 10000;
    private static final float PRICE_UPPER = 30000;


    public CollegeHandler(String name) {
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
