package com.drturner.leetcode.probelm198;

public class RobKing {
    public int rob(int[] nums,boolean odd) {
        int start=odd?1:0;
        int sum=0;
        for (int i=start;i<nums.length;i+=2){
            sum+=nums[i];
        }
        return sum;
    }
    public int rob(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0],nums[1]);
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        dp[2]=Math.max(nums[1],nums[0]+nums[2]);
        int max=Math.max(dp[0],Math.max(dp[1],dp[2]));
        for (int i=3;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-3]+nums[i]);
            max=max>dp[i]?max:dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={1,5,5};
        RobKing robKing = new RobKing();
        int rob = robKing.rob(nums);
        System.out.println(rob);
    }
}
