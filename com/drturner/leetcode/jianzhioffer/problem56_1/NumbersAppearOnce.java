package com.drturner.leetcode.jianzhioffer.problem56_1;

/**
 * ClassName: NumbersAppearOnce
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/26
 * Version: 1.0
 */
public class NumbersAppearOnce {
    /*
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
    * */
    public int[] singleNumbers(int[] nums) {
        int xor=nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor^=nums[i];
        }
        int t=xor;
        int bit=0;
        int num1=0,num2=0;
        while ((t&(1<<bit))==0) bit++;
        for (int e:nums){
            if ((e&(1<<bit))==0){
                num1^=e;
            }
            else {
                num2^=e;
            }
        }
        return new int[]{num1,num2};
    }

    public static void main(String[] args) {
        NumbersAppearOnce numbersAppearOnce = new NumbersAppearOnce();
        int[] nums={4,-4,1,-4,6,5,6,1};
        int[] ints = numbersAppearOnce.singleNumbers(nums);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
