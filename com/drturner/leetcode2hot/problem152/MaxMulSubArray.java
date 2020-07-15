package com.drturner.leetcode2hot.problem152;

/**
 * ClassName: MaxMulSubArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/15
 * Version: 1.0
 */
public class MaxMulSubArray {
    public int maxProduct(int[] nums) {
      //  int[] dp=new int[nums.length];
        if (nums.length==0) return 0;
        int[] min=new int[nums.length];
        int max=nums[0];
        int last=nums[0];
        min[0]=nums[0];
        //dp[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            min[i]=Math.min(nums[i],Math.min(min[i-1]*nums[i],last*nums[i]));
        //    dp[i]=Math.max(dp[i-1]*nums[i],Math.max(min[i-1]*nums[i],nums[i]));
            last=Math.max(last*nums[i],Math.max(min[i-1]*nums[i],nums[i]));
            max=Math.max(last,max);
        }
      //  for (int i=1;i<nums.length;i++){
       //     dp[i]=Math.max(dp[i-1]*nums[i],Math.max(min[i-1]*nums[i],nums[i]));
     //   }
        return max;
    }

    public static void main(String[] args) {
        MaxMulSubArray maxMulSubArray = new MaxMulSubArray();
        int[] nums={-1,-2,-9,-6};
        int i = maxMulSubArray.maxProduct(nums);
        System.out.println(i);
    }
}
