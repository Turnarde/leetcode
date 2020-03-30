package com.drturner.leetcode.problem53;

public class MaxSumSubArray {
    public int maxSubArray(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int lastMax=nums[0],max=nums[0];
        for (int i=1;i<nums.length;i++)max=(max>(lastMax=(lastMax>0?(lastMax+nums[i]):nums[i]))?max:lastMax);
        return max;
    }
    public int maxSubArray(int[] nums,int index,int maxLast) {
        if (index==nums.length) return maxLast;
        if (maxLast>0){
            return maxLast+nums[index];
        }
        else {
            return nums[index];
        }
    }

    public static void main(String[] args) {
        MaxSumSubArray maxSumSubArray = new MaxSumSubArray();
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSumSubArray.maxSubArray(nums);
        System.out.println(i);
    }
}
