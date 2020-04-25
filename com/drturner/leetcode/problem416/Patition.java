package com.drturner.leetcode.problem416;

/**
 * ClassName: Patition
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/21
 * Version: 1.0
 */
public class Patition {
    public boolean canPartitionSubNaive(int[] nums,int index,int sum) {
        if (sum==0) return true;
        if (sum<0) return false;
        if (index==nums.length) return false;
        return canPartitionSubNaive(nums,index+1,sum-nums[index])||canPartitionSubNaive(nums, index+1, sum);
    }
    public boolean canPartitionNaive(int[] nums) {
        int sum=0;
        for (int e:nums)sum+=e;
        if (sum%2==1) return false;
        sum/=2;
        return canPartitionSubNaive(nums,0,sum);
    }

    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int e:nums)sum+=e;
        if (sum%2==1) return false;
        sum/=2;
        boolean [][] dp=new boolean[nums.length][sum+1];
        for (int i=0;i<nums.length;i++)
            dp[i][0]=true;
        for (int i=1;i<dp[0].length;i++){
            dp[nums.length-1][i]=nums[nums.length-1]==i;
        }
        //canPartitionSubNaive(nums,index+1,sum-nums[index])||canPartitionSubNaive(nums, index+1, sum)
        for (int i=nums.length-2;i>=0;i--){
            for (int j=1;j<=sum;j++){
                dp[i][j]=((j-nums[i])>=0&&dp[i+1][j-nums[i]])||(dp[i+1][j]);
            }
        }
        return dp[0][sum];
    }

    private boolean canPartitionSub(int[] nums, int i, int sum) {

        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,5,9,3,11,5};
        Patition patition = new Patition();
        boolean b = patition.canPartition(nums);
        System.out.println(b);
    }
}
