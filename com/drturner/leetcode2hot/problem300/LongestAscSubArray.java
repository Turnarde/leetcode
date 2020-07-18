package com.drturner.leetcode2hot.problem300;

public class LongestAscSubArray {
    public int lengthOfLIS(int[] nums) {
        if (nums.length==0) return 0;
        int[] dp=new int[nums.length];
        dp[0]=1;
        int max=1;
        for (int i=1;i<nums.length;i++){
            int len=0;
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    len=Math.max(len,dp[j]);
                }
            }
            dp[i]=len+1;
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestAscSubArray longestAscSubArray = new LongestAscSubArray();
        int[] nums={};
        int i = longestAscSubArray.lengthOfLIS(nums);
        System.out.println(i);
    }
}
