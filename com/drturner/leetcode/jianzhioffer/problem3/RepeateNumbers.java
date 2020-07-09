package com.drturner.leetcode.jianzhioffer.problem3;

/**
 * ClassName: RepeateNumbers
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/1
 * Version: 1.0
 */
public class RepeateNumbers {
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public int findRepeatNumber(int[] nums) {
        int i=0;
        while (i<nums.length){
            if (nums[i]!=i){
                if (nums[nums[i]]==nums[i])
                    return nums[i];
                swap(nums,nums[i],i);
            }
            else {
                i++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        RepeateNumbers repeateNumbers = new RepeateNumbers();
        int[] nums={2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = repeateNumbers.findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }
}
