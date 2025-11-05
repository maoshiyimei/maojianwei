package com.maji.maojianwei.leetcode.designPatterm.command;

public class ActivityPlayStatusEnd implements ActivityPlayStatus{
    private RaffleActivity activity;

    public ActivityPlayStatusEnd (RaffleActivity activity){
        this.activity = activity;
    }

    @Override
    public void deducePoints() {
        System.out.println(" activity end , game over");
    }

    @Override
    public boolean raffle() {
        System.out.println(" activity end , game over");
        return false;
    }

    @Override
    public void sendPrize() {
        System.out.println(" activity end , game over");
    }
}
