package com.drturner.leetcode.jianzhioffer.problem39;

/**
 * ClassName: MoreThanHalf
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/24
 * Version: 1.0
 */
public class MoreThanHalf {
    public int majorityElement(int[] nums) {
        if (nums.length==0) return -1;
        int can=nums[0];
        int h=1;
        for (int i=1;i<nums.length;i++){
            if (h==0){
                can=nums[i];
                h=1;
            }
            else if (nums[i]==can){
                h++;
            }
            else {
                h--;
            }
        }
        return can;
    }

    public static void main(String[] args) {
        MoreThanHalf moreThanHalf = new MoreThanHalf();
        int[] nums={10,9,10};
        int i = moreThanHalf.majorityElement(nums);
        System.out.println(i);
    }
}
