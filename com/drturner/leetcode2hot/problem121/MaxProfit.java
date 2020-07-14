package com.drturner.leetcode2hot.problem121;

/**
 * ClassName: MaxProfit
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/10
 * Version: 1.0
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int min=prices[0];
        int maxprofit=0;
        for (int i=0;i<prices.length;i++){
            maxprofit=Math.max(prices[i]-min,maxprofit);
            min=Math.min(min,prices[i]);
        }
        return maxprofit;
    }
}
