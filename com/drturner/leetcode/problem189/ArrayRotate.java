package com.drturner.leetcode.problem189;

import com.drturner.leetcode.ArrayPrint;

/**
 * ClassName: ArrayRotate
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/11
 * Version: 1.0
 */
public class ArrayRotate {
    /*
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
    * */
    private void swap(int[] nums,int l,int r){
        int tmp=nums[l];
        nums[l]=nums[r];
        nums[r]=tmp;
    }
    private void reverse(int[] nums,int l,int r){
        while (l<=r){
            swap(nums, l++, r--);
        }
    }
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public static void main(String[] args) {
        ArrayRotate arrayRotate = new ArrayRotate();
        int[] nums={1,2,3,4,5,6,7};
        arrayRotate.rotate(nums,3);
        ArrayPrint.print(nums);
    }
}
