package com.drturner.leetcode.problem322;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CoinsChange {
    Stack<Integer> list=new Stack<>();
    public boolean coinChangeSub(int[] coins, int amount,int count) {
        if (amount==0){
            if (list.isEmpty()||list.peek()>count) {
                list.push(count);
                return true;
            }
        }
        else if (coins[0]>amount) return false;
        int i=coins.length-1;
        for (;i>=0;i--){
            if (coins[i]<=amount){
                boolean b = coinChangeSub(coins, amount - coins[i], count + 1);
                if (b) break;
            }
            else
                break;
        }
        return (i==-1);

    }
    public int coinChangeDP(int[] coins, int amount) {
        if (amount==0) return 0;
        if (coins.length==0) return -1;
        int[][] dp=new int[coins.length+1][amount+1];
        dp[0][0]=0;
        for (int i=1;i<dp[0].length;i++){
            dp[0][i]=Integer.MAX_VALUE;
        }
        for (int i=1;i<dp.length;i++){
            dp[i][0]=0;
        }
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                if (j==coins[i-1]){
                    dp[i][j]=1;
                    continue;
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
                if (j-coins[i-1]>=0&&dp[i][j-coins[i-1]]!=0&&dp[i][j-coins[i-1]]!=Integer.MAX_VALUE){
                    dp[i][j]=Math.min(dp[i][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }
        return dp[coins.length][amount]==Integer.MAX_VALUE?-1:dp[coins.length][amount];
    }

    public static void main(String[] args) {
        CoinsChange coinsChange = new CoinsChange();
        int[] coins={2,5};
        int i = coinsChange.coinChangeDP(coins, 4);
        System.out.println(i);
    }
}
