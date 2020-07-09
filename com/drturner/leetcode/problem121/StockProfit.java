package com.drturner.leetcode.problem121;

public class StockProfit {
    public int maxProfitNaive(int[] prices) {
        int profit=0;
        for (int i=0;i<prices.length;i++){
            for (int j=i+1;j<prices.length;j++){
                profit=profit>prices[j]-prices[i]?profit:prices[j]-prices[i];
            }
        }
        return profit;
    }
    public int maxProfit(int[] prices) {
        if (prices==null||prices.length<1) return 0;
        int min=prices[0];
        int profit=0;
        for (int i=1;i<prices.length;i++){
            profit=Math.max(profit,prices[i]-min);
            min=prices[i]<min?prices[i]:min;
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] prices={7,8};
        StockProfit stockProfit = new StockProfit();
        int i = stockProfit.maxProfit(prices);
        System.out.println(i);
    }
}
