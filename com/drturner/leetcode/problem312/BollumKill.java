package com.drturner.leetcode.problem312;

import java.util.LinkedList;

public class BollumKill {

    public int maxCoinsSub(int[] nums,int i,int j,int[][] dp){
        if (i>j) return 0;
        if (dp[i][j]>0) return dp[i][j];
        for (int k=i;k<=j;k++){
            int left=maxCoinsSub(nums,i,k-1,dp);
            int right=maxCoinsSub(nums,k+1,j,dp);
            dp[i][j]=Math.max(dp[i][j],left+right+nums[i-1]*nums[k]*nums[j+1]);
        }
        return dp[i][j];
    }
    public int maxCoins(int[] nums) {
        if (nums.length==0) return 0;
        int[][] dp=new int[nums.length+2][nums.length+2];
        dp[0][0]=nums[0];
        int[] newNum=new int[nums.length+2];
        newNum[0]=1;newNum[newNum.length-1]=1;
        for (int i=0;i<nums.length;i++) newNum[i+1]=nums[i];
        return maxCoinsSub(newNum,1,nums.length,dp);
    }

    public static void main(String[] args) {
        int[] nums={};
        BollumKill bollumKill = new BollumKill();
        int i = bollumKill.maxCoins(nums);
        System.out.println(i);
    }
}
