package com.drturner.leetcode.problem122;


/**
 * ClassName: StockProfitv2
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/26
 * Version: 1.0
 */
public class StockProfitv2 {
    public int maxProfit(int[] prices) {
        if (prices==null||prices.length<1) return 0;
        int min=prices[0];
        int profit=0;
        for (int i=1;i<prices.length;i++){
            if (prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] prices={7,6,4,3,1};
        StockProfitv2 stockProfit = new StockProfitv2();
        int i = stockProfit.maxProfit(prices);
        System.out.println(i);
    }
}
