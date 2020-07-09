package com.drturner.leetcode.jianzhioffer.problem57;

/**
 * ClassName: TwoSum
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/26
 * Version: 1.0
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int p1=0,p2=nums.length-1;
        while (p1<p2){
            if (nums[p1]+nums[p2]==target){
                return new int[]{nums[p1],nums[p2]};
            }
            if (nums[p1]+nums[p2]<target){
                p1++;
            }
            else {
                p2--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums={1,2,3,4,5,6};
        int[] ints = twoSum.twoSum(nums, 6);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
