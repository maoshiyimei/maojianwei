package com.maji.maojianwei.leetcode.designPatterm.command;

public class RaffleActivity {
    //状态
    private ActivityPlayStatus state;
    //奖品数量
    private int count;

    //构造器，初始化上述两个属性
    public RaffleActivity(int count) {
        //开始是开始抽奖状态。
        state = prepareStatus;
        this.count = count;
    }

    ActivityPlayStatusPrepare prepareStatus = new ActivityPlayStatusPrepare(this);
    ActivityPlayStatusInRaffle inRaffleState = new ActivityPlayStatusInRaffle(this);
    ActivityPlayStatusSendPrize sendPrizeState = new ActivityPlayStatusSendPrize(this);

    ActivityPlayStatusEnd endStatus = new ActivityPlayStatusEnd(this);


    // 当前状态可以扣分，扣分后修改状态
    public void deduceMoney() {
        state.deducePoints();
    }


    public void raffle() {
        if(state.raffle()) {
            state.sendPrize();
        }
    }

    //需要注意，我们的数量应该是递减的
    public int getCount() {
        int countNum = count;
        count--;
        return countNum;
    }

    public ActivityPlayStatus getState() {
        return state;
    }


    public void setState(ActivityPlayStatus state) {
        this.state = state;
    }

    public ActivityPlayStatusPrepare getPrepareStatus() {
        return prepareStatus;
    }

    public ActivityPlayStatusInRaffle getInRaffleState() {
        return inRaffleState;
    }

    public ActivityPlayStatusSendPrize getSendPrizeState() {
        return sendPrizeState;
    }

    public ActivityPlayStatusEnd getEndState() {
        return endStatus;
    }
}

