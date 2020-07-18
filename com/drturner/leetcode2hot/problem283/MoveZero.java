package com.drturner.leetcode2hot.problem283;

public class MoveZero {
    private void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    public void moveZeroes(int[] nums) {
        int zeros=0;
        for (int e:nums)
            zeros=e==0?zeros+1:zeros;
        int curZero=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                swap(nums,i,i-curZero);
            }
            else {
                curZero++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZero moveZero = new MoveZero();
        int[] nums={};
        moveZero.moveZeroes(nums);
        for (int e:nums){
            System.out.println(e);
        }
    }
}
