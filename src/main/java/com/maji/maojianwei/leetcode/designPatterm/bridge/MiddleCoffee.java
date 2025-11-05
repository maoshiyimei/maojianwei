package com.maji.maojianwei.leetcode.designPatterm.bridge;

public class MiddleCoffee extends Coffee{

    public MiddleCoffee(ICoffeeAdditive coffeeAdditive) {
        super(coffeeAdditive);
    }

    @Override
    public void orderCoffee(int count) {
        System.out.println(String.format("order %d middle add %s coffee", count, this.coffeeAdditive.getAdditiveName()));
    }
}
