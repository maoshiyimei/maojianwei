package com.maji.maojianwei.leetcode.designPatterm.command;

public class ActivityPlayStatusPrepare implements ActivityPlayStatus{

    private RaffleActivity activity;

    public ActivityPlayStatusPrepare(RaffleActivity activity) {
        this.activity  = activity;
    }

    @Override
    public void deducePoints() {
        System.out.println(" prepare, deduce 5 points");
        activity.setState(activity.getInRaffleState());
    }

    @Override
    public boolean raffle() {
        System.out.println(" prepare, deduce  points first");
        return false;
    }

    @Override
    public void sendPrize() {
        System.out.println(" prepare, can not send yet");
    }
}
