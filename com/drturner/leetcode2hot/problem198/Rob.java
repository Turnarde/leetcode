package com.drturner.leetcode2hot.problem198;

/**
 * ClassName: Rob
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/15
 * Version: 1.0
 */
public class Rob {
    private int rob(int[] nums,int start){
        if(start>=nums.length) return 0;
        // if(start==nums.length-1) return
        int r1=rob(nums,start+1);
        int r2=rob(nums,start+2)+nums[start];
        return Math.max(r1,r2);
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        dp[nums.length]=0;
        dp[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            dp[i]=Math.max(dp[i+1],i+2>nums.length-1?nums[i]:dp[i+2]+nums[i]);
        }
        //   return rob(nums,0);
        return dp[0];
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums={};
        int rob1 = rob.rob(nums);
        System.out.println(rob1);
    }
}
