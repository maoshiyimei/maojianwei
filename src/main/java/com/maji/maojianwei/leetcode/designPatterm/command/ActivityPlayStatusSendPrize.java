package com.maji.maojianwei.leetcode.designPatterm.command;

public class ActivityPlayStatusSendPrize implements ActivityPlayStatus {
    private RaffleActivity activity;


    public ActivityPlayStatusSendPrize(RaffleActivity activity) {
        this.activity = activity;
    }


    @Override
    public void deducePoints() {
        System.out.println("send prize, no need deduce point");
    }

    @Override
    public boolean raffle() {
        System.out.println("send prize, can not raffle");
        return false;
    }

    @Override
    public void sendPrize() {
        if (activity.getCount() > 0 ) {
            System.out.println("send prize, done ！");
            activity.setState(activity.getPrepareStatus());
        } else {
            System.out.println("send prize, fail, not enough ！");
            activity.setState(activity.getSendPrizeState());
        }

    }
}
