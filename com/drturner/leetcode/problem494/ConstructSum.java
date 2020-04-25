package com.drturner.leetcode.problem494;

/**
 * ClassName: ConstructSum
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/21
 * Version: 1.0
 */

public class ConstructSum {
    public int findTargetSumWaysSubNaive(int[] nums,int index, int S) {
        if (index==nums.length) return S==0?1:0;
     //   if (index==nums.length-1) return (S==nums[index]||S==-nums[index])?1:0;

        return findTargetSumWaysSubNaive(nums,index+1, S+nums[index])+findTargetSumWaysSubNaive(nums,index+1, S-nums[index]);
    }
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for (int e:nums) sum+=e;
        int[][] dp=new int[nums.length][2*sum+1];
        for (int i=-sum;i<=sum;i++){
            if (nums[nums.length-1]==i) dp[nums.length-1][sum+i]=1;
        }
        for (int i=nums.length-2;i>=0;i--){
            for (int j=-sum;j<=sum;j++){
                int t1=(j+nums[i]>=0)&&j+nums[i]<dp[0].length?dp[i+1][sum+j+nums[i]]:0;
                int t2=(j-nums[i]>=0)&&j-nums[i]<dp[0].length?dp[i+1][sum+j-nums[i]]:0;
            //    int t1=(j+nums[i]>=0)&&j+nums[i]<dp[0].length?dp[i+1][j+nums[i]]:0;
            //    int t2=(j-nums[i]>=0)&&j-nums[i]<dp[0].length?dp[i+1][j-nums[i]]:0;
                dp[i][sum+j]=t1+t2;
            }
        }
        return dp[0][S-sum];
    }

    public static void main(String[] args) {
        int[] nums={1,1, 1};
        int S=3;
        ConstructSum constructSum = new ConstructSum();
        int targetSumWays = constructSum.findTargetSumWays(nums, S);
        System.out.println(targetSumWays);
    }
}
