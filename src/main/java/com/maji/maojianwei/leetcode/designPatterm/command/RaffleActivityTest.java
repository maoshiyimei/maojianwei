package com.maji.maojianwei.leetcode.designPatterm.command;

public class RaffleActivityTest {

    public static void main(String[] args){
        RaffleActivity activity = new RaffleActivity(5);

        for (int i = 0 ; i < 50 ; i++){
            System.out.println(String.format("....... %d times ..........." , i));
            activity.deduceMoney();
            activity.raffle();
        }
    }
}
