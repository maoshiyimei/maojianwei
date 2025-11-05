package com.maji.maojianwei.leetcode.designPatterm.bridge;

public abstract class Coffee {
    protected ICoffeeAdditive coffeeAdditive;

    public Coffee(ICoffeeAdditive coffeeAdditive) {
        this.coffeeAdditive = coffeeAdditive;
    }

    public abstract void orderCoffee(int count);
}
