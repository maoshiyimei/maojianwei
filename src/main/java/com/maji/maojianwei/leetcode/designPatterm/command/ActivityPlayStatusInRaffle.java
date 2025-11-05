package com.maji.maojianwei.leetcode.designPatterm.command;

import java.util.Random;

public class ActivityPlayStatusInRaffle implements ActivityPlayStatus{
    private RaffleActivity activity;

    public ActivityPlayStatusInRaffle(RaffleActivity activity){
        this.activity = activity;
    }


    @Override
    public void deducePoints() {
        System.out.println("in raffle , no need to deduce");
    }

    @Override
    public boolean raffle() {
        System.out.println("raffling, wait...");
        int num = new Random().nextInt(5);

        if (num == 0) {
            activity.setState(activity.getSendPrizeState());
            System.out.println("hit, you got it");
            return true;
        } else {
            activity.setState(activity.getPrepareStatus());
            System.out.println("not hit, sorry");
            return false;
        }
    }

    @Override
    public void sendPrize() {
        System.out.println("in raffle, could ont send prize yet");
    }
}
