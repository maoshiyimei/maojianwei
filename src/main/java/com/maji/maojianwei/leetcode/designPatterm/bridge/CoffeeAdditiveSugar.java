package com.maji.maojianwei.leetcode.designPatterm.bridge;

public class CoffeeAdditiveSugar implements ICoffeeAdditive{
    @Override
    public void addAdditive() {
        System.out.println("添加糖");
    }

    @Override
    public String getAdditiveName() {
        return "sugar";
    }
}
