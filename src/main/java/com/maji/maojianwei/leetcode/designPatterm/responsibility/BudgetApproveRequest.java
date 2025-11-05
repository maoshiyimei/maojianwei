package com.maji.maojianwei.leetcode.designPatterm.responsibility;

public class BudgetApproveRequest {

    private int id;
    private float budget;

    public BudgetApproveRequest(int id, float budget) {
        this.id = id;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }
}
