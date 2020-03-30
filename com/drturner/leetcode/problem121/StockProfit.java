package com.drturner.leetcode.problem121;

public class StockProfit {
    public int maxProfit(int[] prices) {
        int profit=0;
        for (int i=0;i<prices.length;i++){
            for (int j=i+1;j<prices.length;j++){
                profit=profit>prices[j]-prices[i]?profit:prices[j]-prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices={7,6,4,3,1};
        StockProfit stockProfit = new StockProfit();
        int i = stockProfit.maxProfit(prices);
        System.out.println(i);
    }
}
