package com.maji.maojianwei.leetcode.designPatterm.bridge;

public class Main {
    public static void main(String[] args){
        Coffee coffee = new LargeCoffee(new CoffeeAdditiveMilk());
        coffee.orderCoffee(3);


        Coffee coffee2 = new MiddleCoffee(new CoffeeAdditiveSugar());
        coffee2.orderCoffee(1);


    }
}
