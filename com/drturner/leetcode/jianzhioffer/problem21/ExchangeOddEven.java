package com.drturner.leetcode.jianzhioffer.problem21;

import com.drturner.leetcode.ArrayPrint;

/**
 * ClassName: ExchangeOddEven
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/13
 * Version: 1.0
 */
public class ExchangeOddEven {
    /*
    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
    * */
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public int[] exchange(int[] nums) {
        int i=-1,j=0;
        while (j<nums.length){
            if (nums[j]%2==1){
                swap(nums,++i,j);
            }
            j++;
        }
        return nums;
    }

    public static void main(String[] args) {
        ExchangeOddEven exchangeOddEven = new ExchangeOddEven();
        int[] nums={};
        exchangeOddEven.exchange(nums);
        ArrayPrint.print(nums);
    }
}
