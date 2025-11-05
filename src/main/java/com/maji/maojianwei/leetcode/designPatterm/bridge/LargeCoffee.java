package com.maji.maojianwei.leetcode.designPatterm.bridge;

public class LargeCoffee extends Coffee{

    public LargeCoffee(ICoffeeAdditive coffeeAdditive) {
        super(coffeeAdditive);
    }

    @Override
    public void orderCoffee(int count) {
        System.out.println(String.format("order %d large add %s coffee", count, this.coffeeAdditive.getAdditiveName()));
    }
}
