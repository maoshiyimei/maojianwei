package com.maji.maojianwei.leetcode.format.greedy;

public class MaxProfit {
    /**
     * 一次遍历即可， 一直发现累加收益开始下降了就更新最大值，如果已经是降低到0了就重新开始
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int accProfit = 0;
        for(int i = 1; i< prices.length; i++) {
            //如果当天的利润是负的，不一定就要立刻放弃可以看下整体利润是不是为正， 但是每一个节点都可以更新下最大值。
            int dailyProfit = prices[i]-prices[i-1];
            if (dailyProfit < 0){
                if(accProfit + dailyProfit > 0 ){
                    accProfit += dailyProfit;
                    maxProfit =Math.max(maxProfit, accProfit);
                }else {
                    accProfit = 0;
                }
            } else {
                accProfit += dailyProfit;
                maxProfit =Math.max(maxProfit, accProfit);
            }
        }

        return maxProfit;
    }

    /**
     * 代码优化：实际上上面的accProfit是不需要的，包含无用计算，只要标识起始买入价格就好了
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length<1){
            return 0;
        }
        int maxProfit = 0;
        int buyIn = prices[0];
        for(int i = 0; i< prices.length; i++){
            int profit = prices[i]-buyIn;
            if(profit < 0){
                buyIn = prices[i];
            }else{
                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;

    }
}
