package com.drturner.leetcode.jianzhioffer.problem42;

/**
 * ClassName: MaxSequenceSum
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/25
 * Version: 1.0
 */
public class MaxSequenceSum {
    public int maxSubArray(int[] nums) {
        int last=nums[0];
        int max=nums[0];
        int t;
        for (int i=1;i<nums.length;i++){
            t=last>0?last+nums[i]:nums[i];
            max=Math.max(max,t);
            last=t;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSequenceSum maxSequenceSum = new MaxSequenceSum();
        int[] nums={1};
        int i = maxSequenceSum.maxSubArray(nums);
        System.out.println(i);
    }
}
