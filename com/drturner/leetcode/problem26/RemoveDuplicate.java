package com.drturner.leetcode.problem26;

/**
 * ClassName: RemoveDuplicate
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/25
 * Version: 1.0
 */
public class RemoveDuplicate {
    private void dup(int[] nums,int cnt){

    }
    public int removeDuplicates(int[] nums) {
        int length=nums.length;
        int cnt=0;
        for (int i=1;i<nums.length;i++){
            if (nums[i-1]==nums[i]) cnt++;
            else {
                nums[i-cnt]=nums[i];
            }
        }
        return length-cnt;
    }

    public static void main(String[] args) {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        int[] nums={};
        int i = removeDuplicate.removeDuplicates(nums);
        System.out.println("i: "+i);
        for (int e:nums) System.out.println(e);
    }
}
