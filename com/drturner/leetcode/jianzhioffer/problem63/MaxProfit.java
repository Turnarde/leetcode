package com.drturner.leetcode.jianzhioffer.problem63;

/**
 * ClassName: MaxProfit
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/27
 * Version: 1.0
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int minValue=prices[0];
        int profit=0;
        for (int i=1;i<prices.length;i++){
            if (prices[i]>minValue){
                profit=Math.max(profit,prices[i]-minValue);
            }
            else {
                minValue=prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices={7};
        int i = maxProfit.maxProfit(prices);
        System.out.println(i);
    }
}
