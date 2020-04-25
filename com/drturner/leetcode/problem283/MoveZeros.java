package com.drturner.leetcode.problem283;

public class MoveZeros {
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public void moveZeroes(int[] nums) {
        int index=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                index++;
            }
            else{
                nums[i-index]=nums[i];
                if (i!=i-index) nums[i]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={1};
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeroes(nums);

    }
}
