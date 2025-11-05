package com.maji.maojianwei.leetcode.designPatterm.bridge;

public class CoffeeAdditiveMilk implements ICoffeeAdditive{
    @Override
    public void addAdditive() {
        System.out.println("添加牛奶");
    }

    @Override
    public String getAdditiveName() {
        return "milk";
    }
}
