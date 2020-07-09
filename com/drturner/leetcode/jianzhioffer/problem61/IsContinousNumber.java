package com.drturner.leetcode.jianzhioffer.problem61;

import java.util.Arrays;

/**
 * ClassName: IsContinousNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/27
 * Version: 1.0
 */
public class IsContinousNumber {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        for (; i<nums.length; i++){
            if (nums[i]!=0) break;;
        }
        for (int j=i;j<nums.length-1;j++){
            if (nums[j+1]!=nums[j]+1){
                if (i==0) return false;
                nums[j]=nums[j]+1;
                j--;
                i--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsContinousNumber isContinousNumber = new IsContinousNumber();
        int[] nums={6,4,1,2,5};
        boolean straight = isContinousNumber.isStraight(nums);
        System.out.println(straight);
    }
}
